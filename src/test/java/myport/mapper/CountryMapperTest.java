package myport.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import myport.domain.CountryVo;
import myport.domain.UserVo;

@SpringBootTest
@Slf4j
public class CountryMapperTest {

	@Autowired
	private CountryMapper mapper;

	// @Test
	public void testMapper() {
		log.info(mapper.toString());
	}

	//@Test
	public void testAddAsset() {
		int result = 0;
		CountryVo paramVo = new CountryVo();
		paramVo.setUNo(1);
		paramVo.setCName("한국");
		paramVo.setCRatio(30);
		result = mapper.addCountry(paramVo);

		log.info("result : " + Integer.toString(result));
	}

	@Test
	public void testRetrieveAssets() {
		UserVo paramVo = new UserVo();
		paramVo.setUNo(1);
		List<CountryVo> result = new ArrayList<CountryVo>();
		result = mapper.retrieveCountries(paramVo);
		log.info("Result size : " + Integer.toString(result.size()));

		if (result.size() > 0) {
			for (CountryVo vo : result) {
				log.info(vo.toString());
			}
		} else {
			log.info("Empty");
		}

	}
}
