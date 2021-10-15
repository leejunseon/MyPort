package myport.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import myport.domain.vo.ItemVo;

@SpringBootTest
@Slf4j
public class ItemServiceTest {

	@Autowired
	private ItemService service;

	//@Test
	public void testService() {
		log.info(service.toString());
	}
	
	@Test
	public void testAddItem() {
		int result = 0;
		ItemVo paramVo = new ItemVo();
		paramVo.setUNo(1);
		paramVo.setCNo(2);
		paramVo.setANo(2);
		paramVo.setIName("DIA");
		paramVo.setIPrice(1200000);
		paramVo.setINum(2);
		result = service.addItem(paramVo);

		log.info("result : " + Integer.toString(result));
	}
}
