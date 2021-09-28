package myport.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import myport.domain.AssetVo;
import myport.domain.UserVo;

@SpringBootTest
@Slf4j
public class AssetServiceTest {

	@Autowired
	private AssetService service;

	// @Test
	public void testService() {
		log.info(service.toString());
	}

	// @Test
	public void testAddAsset() {
		int result = 0;
		AssetVo paramVo = new AssetVo();
		paramVo.setUNo(1);
		paramVo.setAName("주식2");
		paramVo.setARatio(10);
		result = service.addAsset(paramVo);

		log.info("result : " + Integer.toString(result));
	}

	@Test
	public void testGetAssets() {
		UserVo paramVo = new UserVo();
		paramVo.setUNo(1);
		List<AssetVo> result = new ArrayList<AssetVo>();
		result = service.retrieveAssets(paramVo);
		log.info("Result size : " + Integer.toString(result.size()));

		if (result.size() > 0) {
			for (AssetVo vo : result) {
				log.info(vo.toString());
			}
		} else {
			log.info("Empty");
		}

	}
}