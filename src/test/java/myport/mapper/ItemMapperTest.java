package myport.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import myport.domain.vo.ItemVo;

@SpringBootTest
@Slf4j
public class ItemMapperTest {

	@Autowired
	private ItemMapper mapper;

	// @Test
	public void testMapper() {
		log.info(mapper.toString());
	}

	@Test
	public void testAddItem() {
		int result = 0;
		ItemVo paramVo = new ItemVo();
		paramVo.setUNo(1);
		paramVo.setCNo(2);
		paramVo.setAno(2);
		paramVo.setIName("SPY");
		paramVo.setIPrice(1000000);
		paramVo.setINum(3);
		result = mapper.addItem(paramVo);

		log.info("result : " + Integer.toString(result));
	}

}
