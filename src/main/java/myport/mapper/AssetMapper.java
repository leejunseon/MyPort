package myport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myport.domain.AssetVo;
import myport.domain.UserVo;

@Mapper
public interface AssetMapper {
	
	public List<AssetVo> retrieveAssets(UserVo vo);
	
	public int addAsset(AssetVo vo);
	
	public int modifyAssets(AssetVo vo);

}
