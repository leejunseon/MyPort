package myport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
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
	public List<ItemVo> retrieveItems(UserVo vo) {
		return mapper.retrieveItems(vo);
	}

}
