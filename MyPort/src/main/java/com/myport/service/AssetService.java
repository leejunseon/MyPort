package com.myport.service;

import com.myport.domain.AssetVo;

import java.util.List;

public interface AssetService {

    public void registerAsset(AssetVo asset);

    public List<AssetVo> retrieveAsset();

    public AssetVo getAsset(AssetVo asset);

    public int modifyAsset(AssetVo asset);

    public int removeAsset(AssetVo asset);

}
