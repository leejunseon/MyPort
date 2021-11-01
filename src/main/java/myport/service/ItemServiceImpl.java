package myport.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myport.domain.dto.ItemDto;
import myport.domain.dto.ItemInfoDto;
import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;
import myport.mapper.ItemMapper;

@Service
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

	public ItemInfoDto convertVoToDto(List<ItemVo> inputVoList, UserVo vo) {
		ItemInfoDto result = new ItemInfoDto();

		List<ItemDto> itemList = getItemList(inputVoList, vo);
		Map<String, Integer> assetNumList = getAssetNumList(itemList);
		itemList = sortItemList(itemList, assetNumList);

		result.setItemList(itemList);
		result.setAssetNumList(assetNumList);

		return result;
	}

	/* ItemVo -> ItemDto로 변환
	 * - cno, ano => cname, aname
	 * - ratio 계산 
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
	 * 자산 별로 갯수 구하고
	 * 갯수 순으로 내림차순 Sort
	 */
	public Map<String, Integer> getAssetNumList(List<ItemDto> inputVoList) {
		Map<String, Integer> result = new HashMap<String, Integer>();

		for (ItemDto dto : inputVoList) {
			if (result.containsKey(dto.getAName())) {
				result.put(dto.getAName(), result.get(dto.getAName() + 1));
			} else {
				result.put(dto.getAName(), 1);
			}
		}

		// Map.Entry 리스트 작성
		List<Entry<String, Integer>> listEntries = new ArrayList<Entry<String, Integer>>(result.entrySet());

		// 비교함수 Comparator를 사용하여 오름차순으로 정렬
		Collections.sort(listEntries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 오름 차순 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

		return result;
	}
	
	/*
	 * 갯수 -> ratio 내림차순으로 sort
	 */
	public List<ItemDto> sortItemList(List<ItemDto> itemList, Map<String, Integer> assetNumList){
		List<ItemDto> result = new ArrayList<ItemDto>();
		
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
		
		return result;
	}

	public String getCName(Long cNo) {
		return mapper.getCName(cNo);
	}

	public String getAName(Long aNo) {
		return mapper.getAName(aNo);
	}

}
