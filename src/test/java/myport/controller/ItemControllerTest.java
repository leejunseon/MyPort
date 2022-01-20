package myport.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import myport.domain.dto.ItemDetail;
import myport.domain.dto.ItemDto;
import myport.domain.vo.ItemVo;

@SpringBootTest
@Slf4j
public class ItemControllerTest {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	//@Test
	public void testAddItem() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		ItemVo paramVo = new ItemVo();
		paramVo.setUNo(1L);
		paramVo.setANo(2L);
		paramVo.setIName("QQQ");
		paramVo.setIPrice(1500000L);
		paramVo.setINum(5L);

		String jsonInString = mapper.writeValueAsString(paramVo);

		log.info(mockMvc.perform(post("/item/add").contentType(MediaType.APPLICATION_JSON).content(jsonInString))
				.andReturn()
				.getResponse()
				.getContentAsString()
				);

	}
	
	//@Test
	public void testRetrieve() throws Exception{
		log.info(mockMvc.perform(get("/item/1"))
				.andReturn()
				.getResponse()
				.getContentAsString()
				);
	}
	
	@Test
	public void testModify() throws Exception{
		ObjectMapper mapper = new ObjectMapper();

		ItemDto item = new ItemDto(); 
		List<ItemDetail> itemList = new ArrayList<ItemDetail>();
		ItemDetail detail = new ItemDetail();
		detail.setINo(6L); 
		detail.setCName("미국");
		detail.setAName("주식");
		detail.setIName("SPY");
		detail.setIPrice(551855L);
		detail.setINum(3L);
		
		itemList.add(detail);
		item.setItemList(itemList);

		String jsonInString = mapper.writeValueAsString(item);
		
		log.info(mockMvc.perform(post("/item/modify/1").contentType(MediaType.APPLICATION_JSON).content(jsonInString))
				.andReturn()
				.getResponse()
				.getContentAsString()
				);
	}
}
