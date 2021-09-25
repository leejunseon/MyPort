package myport.mapper;

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
public class AssetMapperTest {

	@Autowired
	private AssetMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper.toString());
	}

	@Test
	public void testGetAssets() {
		UserVo param = new UserVo();
		param.setUNo(1);
		List<AssetVo> result = new ArrayList<AssetVo>();
		result = mapper.getAssets(param);
		log.info(Integer.toString(result.size()));

		if (result.size() > 0) {
			for (AssetVo vo : result) {
				log.info(vo.toString());
			}
		} else {
			log.info("Empty");
		}

	}
}
