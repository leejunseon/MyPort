package com.myport.service;

import com.myport.domain.ItemVo;

import java.util.List;

public interface ItemService {

    public void registerItem(ItemVo item);

    public List<ItemVo> retrieveItem(ItemVo item);

    public ItemVo getItem(ItemVo item);

    public int modifyItem(ItemVo item);

    public int removeItem(ItemVo item);

}
