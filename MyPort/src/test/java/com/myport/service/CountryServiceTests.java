package com.myport.service;

import com.myport.domain.CountryVo;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CountryServiceTests {

    @Setter(onMethod_ = @Autowired)
    private CountryService service;

    @Test
    public void testExist(){
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegister(){
        CountryVo vo = new CountryVo();
        vo.setUNo(1L);
        vo.setCName("미국");
        vo.setCRatio(70L);
        service.registerCountry(vo);
    }

    @Test
    public void testRetrieveCountry(){
        for(CountryVo vo : service.retrieveCountry()){
            log.info(vo);
        }
    }

    @Test
    public void testModifyCountry(){
        CountryVo vo = new CountryVo();
        vo.setCNo(21L);
        vo.setCName("미국 업데이트");
        int result = service.modifyCountry(vo);
        log.info(result);
    }

    @Test
    public void testDelete(){
        CountryVo vo = new CountryVo();
        vo.setCNo(21L);
        int result = service.removeCountry(vo);
        log.info(result);
    }
}