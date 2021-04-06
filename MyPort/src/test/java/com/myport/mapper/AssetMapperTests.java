package com.myport.mapper;

import com.myport.domain.AssetVo;
import com.myport.domain.CountryVo;
import com.myport.domain.UserVo;
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
public class AssetMapperTests {

    @Setter(onMethod_=@Autowired)
    private AssetMapper aMapper;

    @Setter(onMethod_=@Autowired)
    private UserMapper uMapper;

    @Test
    public void testInsert(){
        AssetVo aVo = new AssetVo();
        UserVo uVo = new UserVo();
        uVo.setUId("testId1");
        aVo.setUNo(uMapper.selectKey(uVo));
        aVo.setAName("주식");
        aVo.setARatio(70L);
        aMapper.insert(aVo);
    }

    @Test
    public void testGetList(){
        for(AssetVo vo : aMapper.getList()){
            log.info(vo);
        }
    }

    @Test
    public void testSelectKey(){
        AssetVo vo = new AssetVo();
        vo.setUNo(2L);
        vo.setAName("주식");
        Long key = aMapper.selectKey(vo);
        log.info(key);
    }

    @Test
    public void testSelect(){
        AssetVo vo = new AssetVo();
        vo.setANo(1L);
        AssetVo result = aMapper.select(vo);
        log.info(result);
    }

    @Test
    public void testUpdate(){
        AssetVo vo = new AssetVo();
        vo.setANo(1L);
        vo.setARatio(90L);
        int result = aMapper.update(vo);
        log.info(result);
    }

    @Test
    public void testDelete(){
        AssetVo vo = new AssetVo();
        vo.setANo(1L);
        int result = aMapper.delete(vo);
        log.info(result);
    }

}
