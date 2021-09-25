package myport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myport.domain.AssetVo;
import myport.domain.UserVo;

@Mapper
public interface AssetMapper {
	
	public List<AssetVo> getAssets(UserVo vo);

}
