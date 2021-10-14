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
import myport.domain.vo.CountryVo;

@SpringBootTest
@Slf4j
public class CountryControllerTest {
	
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//@Test
	public void testRetrieve() throws Exception{
		log.info(mockMvc.perform(get("/country/1"))
				.andReturn()
				.getResponse()
				.getContentAsString()
				);
	}
	
	//@Test
	public void testAddCountry() throws Exception{
		log.info(mockMvc.perform(post("/country/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"uNo\":\"1\",\"cName\":\"캄보디아\",\"cRatio\":\"20\"}"))
				.andReturn()
				.getResponse()
				.getContentAsString()
				);
	}
	
	// @Test
	public void testModifyCountries() throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		List<CountryVo> paramVoList  = new ArrayList<CountryVo>();
		
		CountryVo paramOne = new CountryVo();
		paramOne.setUNo(1);
		paramOne.setCName("미국");
		paramOne.setCRatio(30);
		paramVoList.add(paramOne);
		
		CountryVo paramTwo = new CountryVo();
		paramTwo.setUNo(1);
		paramTwo.setCName("한국");
		paramTwo.setCRatio(30);
		paramVoList.add(paramTwo);
		
		String jsonInString = mapper.writeValueAsString(paramVoList);
		
		log.info(mockMvc.perform(post("/country/modify")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonInString))
				.andReturn()
				.getResponse()
				.getContentAsString()
				);
	}
	
	@Test
	public void testDeleteAssets() throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		List<CountryVo> paramVoList  = new ArrayList<CountryVo>();
		
		CountryVo paramOne = new CountryVo();
		paramOne.setUNo(1);
		paramOne.setCName("미국");
		paramVoList.add(paramOne);
		
		CountryVo paramTwo = new CountryVo();
		paramTwo.setUNo(1);
		paramTwo.setCName("한국");
		paramVoList.add(paramTwo);
		
		String jsonInString = mapper.writeValueAsString(paramVoList);
		
		log.info(mockMvc.perform(post("/asset/delete")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonInString))
				.andReturn()
				.getResponse()
				.getContentAsString()
				);
	}
	
}