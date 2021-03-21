package com.myport.persistence;

import com.myport.mapper.SampleMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleMapperTests {

    @Setter(onMethod_=@Autowired)
    private SampleMapper sampleMapper;

    @Test
    public void testGetTime(){
        log.info(sampleMapper.getClass().getName());
        log.info(sampleMapper.getTime());
    }

    @Test
    public void testGetTime2(){
        log.info("getTime2");
        log.info(sampleMapper.getTime2());
    }
}
