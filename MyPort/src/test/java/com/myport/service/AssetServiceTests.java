package com.myport.service;


import com.myport.domain.AssetVo;
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
public class AssetServiceTests {

    @Setter(onMethod_ = @Autowired)
    private AssetService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegister(){
        AssetVo vo = new AssetVo();
        vo.setUNo(1L);
        vo.setAName("채권1");
        vo.setARatio(30L);
        service.registerAsset(vo);
    }

    @Test
    public void testRetrieveAsset(){
        for(AssetVo vo : service.retrieveAsset()){
            log.info(vo);
        }
    }

    @Test
    public void testGetAsset(){
        AssetVo vo = new AssetVo();
        vo.setANo(2L);
        AssetVo result = service.getAsset(vo);
        log.info(result);
    }

    @Test
    public void testModifyAsset(){
        AssetVo vo = new AssetVo();
        vo.setANo(21L);
        vo.setAName("hhhhhhh");
        int result = service.modifyAsset(vo);
        log.info(result);
    }

    @Test
    public void testRemoveAsset(){
        AssetVo vo = new AssetVo();
        vo.setANo(22L);
        int result = service.removeAsset(vo);
        log.info(result);
    }
}