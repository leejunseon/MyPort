package myport.service;

import java.util.List;

import myport.domain.dto.ItemDto;
import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;

public interface ItemService {

	public int addItem(ItemVo vo);
	
	public List<ItemDto> retrieveItems(UserVo vo);
	
}
