package myport.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import myport.domain.vo.AssetVo;
import myport.domain.vo.UserVo;

@SpringBootTest
@Slf4j
public class AssetMapperTest {

	@Autowired
	private AssetMapper mapper;

	// @Test
	public void testMapper() {
		log.info(mapper.toString());
	}

	// @Test
	public void testAddAsset() {
		int result = 0;
		AssetVo paramVo = new AssetVo();
		paramVo.setUNo(1);
		paramVo.setAName("주식1");
		paramVo.setARatio(50);
		result = mapper.addAsset(paramVo);

		log.info("result : " + Integer.toString(result));
	}

	//@Test
	public void testRetrieveAssets() {
		UserVo paramVo = new UserVo();
		paramVo.setUNo(1);
		List<AssetVo> result = new ArrayList<AssetVo>();
		result = mapper.retrieveAssets(paramVo);
		log.info("Result size : " + Integer.toString(result.size()));

		if (result.size() > 0) {
			for (AssetVo vo : result) {
				log.info(vo.toString());
			}
		} else {
			log.info("Empty");
		}
	}
	
	// @Test
	public void testModifyAssets() {
		AssetVo paramVo  = new AssetVo();
		paramVo.setUNo(1);
		paramVo.setAName("주식1");
		paramVo.setARatio(30);
		int result = mapper.modifyAssets(paramVo);
		log.info("Updated row : " + result);
	}
	
	@Test
	public void testDeleteAsset() {
		AssetVo paramVo  = new AssetVo();
		paramVo.setANo(51);
		int result = mapper.deleteAsset(paramVo);
		log.info("Deleted row : " + result);	
	}
	
}
