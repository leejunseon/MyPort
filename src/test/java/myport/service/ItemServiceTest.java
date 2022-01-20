package myport.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import myport.domain.dto.ItemDetail;
import myport.domain.dto.ItemDto;
import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;

@SpringBootTest
@Slf4j
public class ItemServiceTest {

	@Autowired
	private ItemService service;

	// @Test
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

	// @Test
	public void testRetrieveItems() {
		UserVo paramVo = new UserVo();
		paramVo.setUNo(1L);
		ItemDto result = new ItemDto();
		result = service.retrieveItems(paramVo);
		log.info("result : " + result.toString());
	}
	
	
	@Test 
	public void testModifyItems() { 
		UserVo user = new UserVo();
		user.setUNo(1L);
	  
		ItemDto item = new ItemDto(); 
		List<ItemDetail> itemList = new ArrayList<ItemDetail>();
		ItemDetail detail = new ItemDetail();
		detail.setINo(6L); 
		detail.setCName("미국");
		detail.setAName("주식");
		detail.setIName("SPY");
		detail.setIPrice(551855L);
		detail.setINum(2L);
		
		itemList.add(detail);
		item.setItemList(itemList);
		
		int result = service.modifyItems(user, item);
	  
		log.info("result : "+result);
	}
	 
}
