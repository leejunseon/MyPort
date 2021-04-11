package com.myport.service;

import com.myport.domain.AssetVo;
import com.myport.mapper.AssetMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssetServiceImpl implements AssetService{

    private AssetMapper mapper;

    @Override
    public void registerAsset(AssetVo asset) {
        mapper.insert(asset);
    }

    @Override
    public List<AssetVo> retrieveAsset() {
        return mapper.getList();
    }

    @Override
    public AssetVo getAsset(AssetVo asset) {
        return mapper.select(asset);
    }

    @Override
    public int modifyAsset(AssetVo asset) {
        return mapper.update(asset);
    }

    @Override
    public int removeAsset(AssetVo asset) {
        return mapper.delete(asset);
    }
}
