package myport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;

@Mapper
public interface ItemMapper {

	public int addItem(ItemVo vo);
	
	public List<ItemVo> retrieveItems(UserVo vo);
	
	public Long getTotalPrice(UserVo vo);
			
	public int modifyItems(ItemVo vo);

	public Long getCNo(String cName);

	public String getAno(String aName);
	
}
