package myport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myport.domain.AssetVo;
import myport.domain.UserVo;
import myport.mapper.AssetMapper;

@Service
@AllArgsConstructor
public class AssetServiceImpl implements AssetService{
	
	private AssetMapper mapper;

	@Override
	public List<AssetVo> retrieveAssets(UserVo vo) {
		return mapper.retrieveAssets(vo);
	}

	@Override
	public int addAsset(AssetVo vo) {
		return mapper.addAsset(vo);
	}

	@Override
	public int modifyAssets(List<AssetVo> voList) {
		int updatedRow = 0;
		for(AssetVo paramVo : voList) {
			updatedRow += mapper.modifyAssets(paramVo);
		}
		return updatedRow;
	}


}
