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
import myport.domain.vo.AssetVo;

@SpringBootTest
@Slf4j
public class AssetControllerTest {
	
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//@Test
	public void testRetrieve() throws Exception{
		log.info(mockMvc.perform(get("/asset/1"))
				.andReturn()
				.getResponse()
				.getContentAsString()
				);
	}
	
	//@Test
	public void testAddAsset() throws Exception{
		log.info(mockMvc.perform(post("/asset/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"uNo\":\"1\",\"aName\":\"채권2\",\"aRatio\":\"20\"}"))
				.andReturn()
				.getResponse()
				.getContentAsString()
				);
	}
	
	//@Test
	public void testModifyAssets() throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		List<AssetVo> paramVoList  = new ArrayList<AssetVo>();
		
		AssetVo paramOne = new AssetVo();
		paramOne.setUNo(1);
		paramOne.setAName("주식1");
		paramOne.setARatio(50);
		paramVoList.add(paramOne);
		
		AssetVo paramTwo = new AssetVo();
		paramTwo.setUNo(1);
		paramTwo.setAName("채권1");
		paramTwo.setARatio(50);
		paramVoList.add(paramTwo);
		
		String jsonInString = mapper.writeValueAsString(paramVoList);
		
		log.info(mockMvc.perform(post("/asset/modify")
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
		List<AssetVo> paramVoList  = new ArrayList<AssetVo>();
		
		AssetVo paramOne = new AssetVo();
		paramOne.setUNo(1);
		paramOne.setAName("주식1");
		paramVoList.add(paramOne);
		
		AssetVo paramTwo = new AssetVo();
		paramTwo.setUNo(1);
		paramTwo.setAName("채권1");
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
