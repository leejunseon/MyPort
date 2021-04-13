package com.myport.service;


import com.myport.domain.ItemVo;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ItemServiceTests {

    @Setter(onMethod_=@Autowired)
    private ItemService service;

    @Test
    public void testExist(){
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegister(){
        ItemVo vo = new ItemVo();
        vo.setUNo(1L);
        vo.setCNo(1L);
        vo.setANo(3L);
        vo.setIName("주식1");
        vo.setIPrice(100000L);
        vo.setINum(10000L);
        service.registerItem(vo);
    }

    @Test
    public void testRetrieveItem(){
        ItemVo param = new ItemVo();
        param.setANo(3L);
        List<ItemVo> result = service.retrieveItem(param);
        for(ItemVo vo : result){
            log.info(vo);
        }
    }

    @Test
    public void testGetItem(){
        ItemVo vo = new ItemVo();
        vo.setINo(2L);
        ItemVo result = service.getItem(vo);
        log.info(result);
    }

    @Test
    public void testModifyItem(){
       ItemVo vo = new ItemVo();
       vo.setINo(2L);
       vo.setIName("주식 업뎃");
       int result = service.modifyItem(vo);
       log.info(result);
    }

    @Test
    public void testRemoveItem(){
        ItemVo vo = new ItemVo();
        vo.setINo(2L);
        int result = service.removeItem(vo);
        log.info(result);
    }

}
