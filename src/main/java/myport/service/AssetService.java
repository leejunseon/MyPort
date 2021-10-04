package myport.service;

import java.util.List;

import myport.domain.AssetVo;
import myport.domain.UserVo;

public interface AssetService {

	public List<AssetVo> retrieveAssets(UserVo vo);

	public int addAsset(AssetVo vo);
	
	public int modifyAssets(List<AssetVo> voList);
	
	public int deleteAssets(List<AssetVo> voList);
	
}
