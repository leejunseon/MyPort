package myport.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myport.domain.dto.ItemDto;
import myport.domain.dto.ItemInfoDto;
import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;
import myport.mapper.ItemMapper;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService{

	private ItemMapper mapper;

	@Override
	public int addItem(ItemVo vo) {
		return mapper.addItem(vo);
	}

	@Override
	public ItemInfoDto retrieveItems(UserVo vo) {
		List<ItemVo> resultVo = mapper.retrieveItems(vo);
		return convertVoToDto(resultVo,vo);
	}
	
	public ItemInfoDto convertVoToDto(List<ItemVo> inputVoList, UserVo vo){
		ItemInfoDto result = new ItemInfoDto();
		
		List<ItemDto> resultDtos = new ArrayList<ItemDto>();
		Map<String,Integer> assetNumList = new HashMap<String,Integer>();
		Long totalPrice = mapper.getTotalPrice(vo);
		
		for(ItemVo inputVo : inputVoList) {
			ItemDto dto= new ItemDto();
			dto.setINo(inputVo.getINo());
			dto.setCName(inputVo.getCName());
			dto.setAName(inputVo.getAName());
			dto.setIName(inputVo.getIName());
			dto.setIPrice(inputVo.getIPrice());
			dto.setINum(inputVo.getINum());
			
			Double price = inputVo.getIPrice()*inputVo.getINum().doubleValue();
			Double ratio = price/totalPrice.doubleValue()*100;
			dto.setIRatio(ratio.longValue());
			
			resultDtos.add(dto);
		}
		
		result.setItemList(resultDtos);
		
		return result;
	}

}
