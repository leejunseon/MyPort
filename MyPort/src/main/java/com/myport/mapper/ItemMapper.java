package com.myport.mapper;

import com.myport.domain.ItemVo;

import java.util.List;

public interface ItemMapper {

    public void insert(ItemVo item);

    public List<ItemVo> getList(ItemVo item);

    public ItemVo select(ItemVo item);

    public Long selectKey(ItemVo item);

    public int update(ItemVo item);

    public int delete(ItemVo item);

}
