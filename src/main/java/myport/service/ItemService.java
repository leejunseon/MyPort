package myport.service;

import myport.domain.dto.ItemDto;
import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;

public interface ItemService {

	public int addItem(ItemVo vo);
	
	public ItemDto retrieveItems(UserVo vo);
	
	public int modifyItems(ItemDto dto);

}
