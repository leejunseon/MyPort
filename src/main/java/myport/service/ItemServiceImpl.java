package myport.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myport.domain.dto.ItemDto;
import myport.domain.dto.ItemInfoDto;
import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;
import myport.mapper.ItemMapper;

@Service
@Slf4j
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

	private ItemMapper mapper;

	@Override
	public int addItem(ItemVo vo) {
		return mapper.addItem(vo);
	}

	@Override
	public ItemInfoDto retrieveItems(UserVo vo) {
		List<ItemVo> resultVo = mapper.retrieveItems(vo);
		return convertVoToDto(resultVo, vo);
	}

	/*
	 * ItemVo -> ItemDto로 변환
	 */
	public ItemInfoDto convertVoToDto(List<ItemVo> inputVoList, UserVo vo) {
		ItemInfoDto result = new ItemInfoDto();

		List<ItemDto> itemList = getItemList(inputVoList, vo);
		Map<String, Integer> assetNumList = getAssetNumList(itemList);
		itemList = sortItemList(itemList, assetNumList);
		
		Long maxRatio = -1L;
		for(ItemDto dto : itemList) {
			if(maxRatio<=dto.getIRatio()) {
				maxRatio = dto.getIRatio();
			}
		}

		result.setItemList(itemList);
		result.setAssetNumList(assetNumList);
		result.setMaxRatio(maxRatio);

		return result;
	}

	/* 
	 * cno, ano => cname, aname
	 * ratio 계산 
	 */
	public List<ItemDto> getItemList(List<ItemVo> inputVoList, UserVo vo) {
		List<ItemDto> resultDtos = new ArrayList<ItemDto>();
		Long totalPrice = mapper.getTotalPrice(vo);

		for (ItemVo inputVo : inputVoList) {
			ItemDto dto = new ItemDto();
			dto.setINo(inputVo.getINo());
			dto.setCName(getCName(inputVo.getCNo()));
			dto.setAName(getAName(inputVo.getANo()));
			dto.setIName(inputVo.getIName());
			dto.setIPrice(inputVo.getIPrice());
			dto.setINum(inputVo.getINum());

			Double price = inputVo.getIPrice() * inputVo.getINum().doubleValue();
			Double ratio = price / totalPrice.doubleValue() * 100;
			dto.setIRatio(ratio.longValue());

			resultDtos.add(dto);
		}
		
		return resultDtos;
	}

	/*
	 * 자산 별로 갯수 구함 (key : 자산, value : 갯수)
	 * value로 map 내림차순 sort
	 */
	public Map<String, Integer> getAssetNumList(List<ItemDto> inputVoList) {
		Map<String, Integer> assetNumMap = new HashMap<String, Integer>();

		for (ItemDto dto : inputVoList) {
			if (assetNumMap.containsKey(dto.getAName())) {
				assetNumMap.put(dto.getAName(), assetNumMap.get(dto.getAName())+1);
			} else {
				assetNumMap.put(dto.getAName(), 1);
			}
		}
		log.info("Asset Num Map(before sort) : "+assetNumMap.toString());

		List<Entry<String, Integer>> listEntries = new ArrayList<Entry<String, Integer>>(assetNumMap.entrySet());

		Collections.sort(listEntries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		Map<String, Integer> result = new LinkedHashMap<String, Integer>();
	    for (Entry<String, Integer> entry : listEntries) {
	        result.put(entry.getKey(), entry.getValue());
	    }
		log.info("Asset Num Map(after sort) : "+result.toString());

		return result;
	}
	
	/*
	 * 자산 갯수 -> ratio 순 내림차순으로 sort
	 */
	public List<ItemDto> sortItemList(List<ItemDto> itemList, Map<String, Integer> assetNumList){
		
		Collections.sort(itemList,new Comparator<ItemDto>() {

			@Override
			public int compare(ItemDto dto1, ItemDto dto2) {
				// TODO Auto-generated method stub
				if(assetNumList.get(dto1.getAName())==assetNumList.get(dto2.getAName())){
					double res = dto2.getIRatio()-dto1.getIRatio();
					if(res<0)
						return -1;
					else
						return 1;
				}else {
					return assetNumList.get(dto2.getAName())-assetNumList.get(dto1.getAName());
				}
			}
			
		});
		
		return itemList;
	}

	public String getCName(Long cNo) {
		return mapper.getCName(cNo);
	}

	public String getAName(Long aNo) {
		return mapper.getAName(aNo);
	}

}
