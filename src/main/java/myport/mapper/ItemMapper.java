package myport.mapper;

import org.apache.ibatis.annotations.Mapper;

import myport.domain.vo.ItemVo;

@Mapper
public interface ItemMapper {

	public int addItem(ItemVo vo);
}
