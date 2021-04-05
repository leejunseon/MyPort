package com.myport.mapper;

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
public class CountryMapperTests {

    @Setter(onMethod_=@Autowired)
    private CountryMapper cMapper;

    @Setter(onMethod_=@Autowired)
    private UserMapper uMapper;

    @Test
    public void testInsert(){
        CountryVo cVo = new CountryVo();
        UserVo uVo = new UserVo();
        uVo.setUId("testId1");
        cVo.setUNo(uMapper.selectKey(uVo));
        cVo.setCName("한국");
        cVo.setCRatio(50L);
        cMapper.insert(cVo);
    }

    @Test
    public void testGetList(){
        for(CountryVo vo : cMapper.getList()){
            log.info(vo);
        }
    }

    @Test
    public void testSelectKey(){
        CountryVo vo = new CountryVo();
        vo.setUNo(2L);
        vo.setCName("한국");
        Long key = cMapper.selectKey(vo);
        log.info(key);
    }

    @Test
    public void testSelect(){
        CountryVo vo = new CountryVo();
        vo.setCNo(2L);
        CountryVo result = cMapper.select(vo);
        log.info(result);
    }

    @Test
    public void testUpdate(){
        CountryVo vo = new CountryVo();
        vo.setCNo(2L);
        vo.setCName("한국_update");
        int result = cMapper.update(vo);
        log.info(result);
    }

    @Test
    public void testDelete(){
        CountryVo vo = new CountryVo();
        vo.setCNo(2L);
        int result = cMapper.delete(vo);
        log.info(result);
    }

}
