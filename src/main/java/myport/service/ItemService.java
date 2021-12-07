package myport.service;

import myport.domain.dto.ItemInfoDto;
import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;

public interface ItemService {

	public int addItem(ItemVo vo);
	
	public ItemInfoDto retrieveItems(UserVo vo);
	
	public int modifyItems(ItemInfoDto dto);

}
