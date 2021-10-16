package myport.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import myport.domain.vo.CountryVo;
import myport.domain.vo.UserVo;

@SpringBootTest
@Slf4j
public class CountryServiceTest {

	@Autowired
	private CountryService service;

	// @Test
	public void testService() {
		log.info(service.toString());
	}

	// @Test
	public void testAddCountry() {
		int result = 0;
		CountryVo paramVo = new CountryVo();
		paramVo.setUNo(1L);
		paramVo.setCName("중국");
		paramVo.setCRatio(10L);
		result = service.addCountry(paramVo);

		log.info("result : " + Integer.toString(result));
	}

	// @Test
	public void testRetrieveCountries() {
		UserVo paramVo = new UserVo();
		paramVo.setUNo(1L);
		List<CountryVo> result = new ArrayList<CountryVo>();
		result = service.retrieveCountries(paramVo);
		log.info("Result size : " + Integer.toString(result.size()));

		if (result.size() > 0) {
			for (CountryVo vo : result) {
				log.info(vo.toString());
			}
		} else {
			log.info("Empty");
		}

	}
	
	// @Test
	public void testModifyCountries() {
		List<CountryVo> paramVoList  = new ArrayList<CountryVo>();
		
		CountryVo paramOne = new CountryVo();
		paramOne.setUNo(1L);
		paramOne.setCName("미국");
		paramOne.setCRatio(10L);
		paramVoList.add(paramOne);
		
		CountryVo paramTwo = new CountryVo();
		paramTwo.setUNo(1L);
		paramTwo.setCName("한국");
		paramTwo.setCRatio(10L);
		paramVoList.add(paramTwo);
		
		int result = service.modifyCountries(paramVoList);
		log.info("Updated row : " + result);
	}
	
	@Test
	public void testDeleteCountries() {
		List<CountryVo> paramVoList  = new ArrayList<CountryVo>();
		
		CountryVo paramOne = new CountryVo();
		paramOne.setUNo(1L);
		paramOne.setCName("미국");
		paramVoList.add(paramOne);
		
		CountryVo paramTwo = new CountryVo();
		paramTwo.setUNo(1L);
		paramTwo.setCName("중국");
		paramVoList.add(paramTwo);
		
		int result = service.deleteCountries(paramVoList);
		log.info("Deleted row : " + result);
	}
	
}
