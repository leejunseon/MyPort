package myport.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import myport.mapper.TestMapper;

@SpringBootTest
@Slf4j
public class MapperTests {

	@Setter(onMethod_=@Autowired)
	private TestMapper testMapper;
	
	@Test
	public void testMapper() {
		log.info("testMapper class : "+testMapper.getClass().getName());
		log.info("testMapper test : "+testMapper.getTime());
	}
}
