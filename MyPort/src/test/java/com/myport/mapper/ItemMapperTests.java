package com.myport.mapper;

import com.myport.domain.AssetVo;
import com.myport.domain.CountryVo;
import com.myport.domain.ItemVo;
import com.myport.domain.UserVo;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ItemMapperTests {

    @Setter(onMethod_=@Autowired)
    private ItemMapper iMapper;

    @Setter(onMethod_=@Autowired)
    private UserMapper uMapper;

    @Setter(onMethod_=@Autowired)
    private CountryMapper cMapper;

    @Setter(onMethod_=@Autowired)
    private AssetMapper aMapper;

    @Test
    public void testInsert(){
        ItemVo iVo = new ItemVo();
        UserVo uVo = new UserVo();
        CountryVo cVo = new CountryVo();
        AssetVo aVo = new AssetVo();
        uVo.setUId("testId1");
        cVo.setUNo(2L);
        cVo.setCName("한국");
        aVo.setUNo(2L);
        aVo.setAName("주식");
        iVo.setUNo(uMapper.selectKey(uVo));
        iVo.setCNo(cMapper.selectKey(cVo));
        iVo.setANo(aMapper.selectKey(aVo));
        iVo.setIName("떡상주식1");
        iVo.setIPrice(10000000L);
        iVo.setINum(100000L);
        iMapper.insert(iVo);
    }

    @Test
    public void testGetList(){
        ItemVo param = new ItemVo();
        param.setUNo(2L);
        param.setCNo(3L);
        List<ItemVo> result = iMapper.getList(param);
        for(ItemVo vo : result){
            log.info(vo);
        }
    }

    @Test
    public void testSelectKey(){
        ItemVo vo = new ItemVo();
        vo.setUNo(2L);
        vo.setCNo(3L);
        vo.setANo(2L);
        vo.setIName("떡상주식1");
        Long key = iMapper.selectKey(vo);
        log.info(key);
    }

    @Test
    public void testSelect(){
        ItemVo vo = new ItemVo();
        vo.setINo(1L);
        ItemVo result = iMapper.select(vo);
        log.info(result);
    }

    @Test
    public void testUpdate(){
        ItemVo vo = new ItemVo();
        vo.setINo(1L);
        vo.setIName("떡상주식_update");
        int result = iMapper.update(vo);
        log.info(result);
    }

    @Test
    public void testDelete(){
        ItemVo vo = new ItemVo();
        vo.setINo(1L);
        int result = iMapper.delete(vo);
        log.info(result);
    }

}
