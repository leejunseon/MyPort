package myport.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myport.domain.dto.ItemDto;
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
	public List<ItemDto> retrieveItems(UserVo vo) {
		List<ItemVo> resultVo = mapper.retrieveItems(vo);
		return convertVoToDto(resultVo,vo);
	}
	
	public List<ItemDto> convertVoToDto(List<ItemVo> inputVoList, UserVo vo){
		List<ItemDto> resultDtos = new ArrayList<ItemDto>();
		Long totalPrice = mapper.getTotalPrice(vo);
		
		for(ItemVo inputVo : inputVoList) {
			ItemDto dto= new ItemDto();
			dto.setINo(inputVo.getINo());
			dto.setCNo(inputVo.getCNo());
			dto.setANo(inputVo.getANo());
			dto.setIName(inputVo.getIName());
			dto.setIPrice(inputVo.getIPrice());
			dto.setINum(inputVo.getINum());
			
			Double price = inputVo.getIPrice()*inputVo.getINum().doubleValue();
			Double ratio = price/totalPrice*100;
			dto.setIRatio(ratio.longValue());
			
			resultDtos.add(dto);
		}
		return resultDtos;
	}

}
