package myport.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myport.domain.vo.ItemVo;
import myport.mapper.ItemMapper;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService{

	private ItemMapper mapper;

	@Override
	public int addItem(ItemVo vo) {
		return mapper.addItem(vo);
	}

}
