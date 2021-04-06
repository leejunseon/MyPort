package com.myport.mapper;

import com.myport.domain.AssetVo;

import java.util.List;

public interface AssetMapper {

    public void insert(AssetVo asset);

    public List<AssetVo> getList();

    public AssetVo select(AssetVo asset);

    public Long selectKey(AssetVo asset);

    public int update(AssetVo asset);

    public int delete(AssetVo asset);

}
