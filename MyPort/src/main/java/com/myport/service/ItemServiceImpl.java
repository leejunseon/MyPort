package com.myport.service;

import com.myport.domain.ItemVo;
import com.myport.mapper.ItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService{

    private ItemMapper mapper;

    @Override
    public void registerItem(ItemVo item) {
        mapper.insert(item);
    }

    @Override
    public List<ItemVo> retrieveItem(ItemVo item) {
        return mapper.getList(item);
    }

    @Override
    public ItemVo getItem(ItemVo item) {
        return mapper.select(item);
    }

    @Override
    public int modifyItem(ItemVo item) {
        return mapper.update(item);
    }

    @Override
    public int removeItem(ItemVo item) {
        return mapper.delete(item);
    }
}
