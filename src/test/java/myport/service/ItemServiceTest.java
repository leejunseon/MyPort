package myport.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import myport.domain.dto.ItemDetail;
import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;

@SpringBootTest
@Slf4j
public class ItemServiceTest {

	@Autowired
	private ItemService service;

	//@Test
	public void testService() {
		log.info(service.toString());
	}
	
	// @Test
	public void testAddItem() {
		int result = 0;
		ItemVo paramVo = new ItemVo();
		paramVo.setUNo(1L);
		paramVo.setCNo(2L);
		paramVo.setANo(2L);
		paramVo.setIName("DIA");
		paramVo.setIPrice(1200000L);
		paramVo.setINum(2L);
		result = service.addItem(paramVo);

		log.info("result : " + Integer.toString(result));
	}
	
	@Test
	public void testRetrieveItems() {
		/*
		 * UserVo paramVo = new UserVo(); paramVo.setUNo(1L); List<ItemDto> result = new
		 * ArrayList<ItemDto>(); result = service.retrieveItems(paramVo);
		 * log.info("Result size : " + Integer.toString(result.size()));
		 * 
		 * if (result.size() > 0) { for (ItemDto vo : result) { log.info(vo.toString());
		 * } } else { log.info("Empty"); }
		 */

	}
}
