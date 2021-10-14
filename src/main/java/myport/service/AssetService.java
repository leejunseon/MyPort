package myport.service;

import java.util.List;

import myport.domain.vo.AssetVo;
import myport.domain.vo.UserVo;

public interface AssetService {

	public List<AssetVo> retrieveAssets(UserVo vo);

	public int addAsset(AssetVo vo);
	
	public int modifyAssets(List<AssetVo> voList);
	
	public int deleteAssets(List<AssetVo> voList);
	
}
