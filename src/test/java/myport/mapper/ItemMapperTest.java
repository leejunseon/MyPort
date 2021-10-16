package myport.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;

@SpringBootTest
@Slf4j
public class ItemMapperTest {

	@Autowired
	private ItemMapper mapper;

	// @Test
	public void testMapper() {
		log.info(mapper.toString());
	}

	// @Test
	public void testAddItem() {
		int result = 0;
		ItemVo paramVo = new ItemVo();
		paramVo.setUNo(1);
		paramVo.setANo(2);
		paramVo.setIName("SPY");
		paramVo.setIPrice(1000000);
		paramVo.setINum(3);
		result = mapper.addItem(paramVo);
		log.info(paramVo.toString());
		log.info("result : " + Integer.toString(result));
	}
	
	@Test
	public void testRetrieveItems() {
		UserVo paramVo = new UserVo();
		paramVo.setUNo(1);
		List<ItemVo> result = new ArrayList<ItemVo>();
		result = mapper.retrieveItems(paramVo);
		log.info("Result size : " + Integer.toString(result.size()));

		if (result.size() > 0) {
			for (ItemVo vo : result) {
				log.info(vo.toString());
			}
		} else {
			log.info("Empty");
		}
	}

}
