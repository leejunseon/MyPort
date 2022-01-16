package myport.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myport.domain.dto.ItemDetail;
import myport.domain.dto.ItemDto;
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
	public ItemDto retrieveItems(UserVo vo) {
		List<ItemVo> resultVo = mapper.retrieveItems(vo);
		return convertVoToDto(resultVo, vo);
	}
	
	@Override
	public int modifyItems(ItemDto dto) {
		int updatedRow = 0;
		List<ItemDetail> itemList= dto.getItemList();
		
		return 0;
	}

	/*
	 * ItemVo -> ItemDto로 변환
	 */
	public ItemDto convertVoToDto(List<ItemVo> inputVoList, UserVo vo) {
		ItemDto result = new ItemDto();

		List<ItemDetail> itemList = getItemList(inputVoList, vo);
		Map<String, Integer> assetNumList = getAssetNumList(itemList);
		itemList = sortItemList(itemList, assetNumList);
		
		Set<String> countryList = getCountryList(itemList);
		
		Long maxRatio = getMaxRatio(itemList);

		result.setItemList(itemList);
		result.setAssetNumList(assetNumList);
		result.setCountryList(countryList);
		result.setMaxRatio(maxRatio);

		return result;
	}
	
	/*
	 * public ItemVo convertDtoToVo(ItemDetail item) { ItemVo result = new ItemVo();
	 * result.setINo(item.getINo()); result.setCNo(item.getc); return result; }d
	 */

	/* 
	 * cno, ano => cname, aname
	 * ratio 계산 
	 */
	public List<ItemDetail> getItemList(List<ItemVo> inputVoList, UserVo vo) {
		List<ItemDetail> resultDtos = new ArrayList<ItemDetail>();
		Long totalPrice = mapper.getTotalPrice(vo);

		for (ItemVo inputVo : inputVoList) {
			ItemDetail dto = new ItemDetail();
			dto.setINo(inputVo.getINo());
			if(inputVo.getCNo()!=null)
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
	public Map<String, Integer> getAssetNumList(List<ItemDetail> inputVoList) {
		Map<String, Integer> assetNumMap = new LinkedHashMap<String, Integer>();

		for (ItemDetail dto : inputVoList) {
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
	public List<ItemDetail> sortItemList(List<ItemDetail> itemList, Map<String, Integer> assetNumList){
		
		Collections.sort(itemList,new Comparator<ItemDetail>() {

			@Override
			public int compare(ItemDetail dto1, ItemDetail dto2) {
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
	
	/*
	 * 최대ratio 구하기
	 */
	public Long getMaxRatio(List<ItemDetail> itemList) {
		Long result = -1L;
		
		for(ItemDetail dto : itemList) {
			if(result<=dto.getIRatio()) {
				result = dto.getIRatio();
			}
		}
		
		return result;
	}

	/*
	 * Country List 구하기
	 */
	public Set<String> getCountryList(List<ItemDetail> itemList) {
		Set<String> result = new TreeSet<String>();
		
		for(ItemDetail dto : itemList) {
			String country = dto.getCName();
			if(country!=null)
				result.add(country);
		}
		
		return result;
	}
	
	public String getCName(Long cNo) {
		return mapper.getCName(cNo);
	}

	public String getAName(Long aNo) {
		return mapper.getAName(aNo);
	}
	
	public String getCno(String cName) {
		return mapper.getCNo(cName);
	}
	
	public String getAno(String aName) {
		return mapper.getAno(aName);
	}

}
