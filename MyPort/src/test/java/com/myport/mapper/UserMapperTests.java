package com.myport.mapper;

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
public class UserMapperTests {

    @Setter(onMethod_=@Autowired)
    private UserMapper uMapper;

    @Test
    public void testInsert(){
        UserVo vo = new UserVo();
        vo.setUId("testId1");
        vo.setUPw("testPw");
        vo.setUName("testName");
        vo.setUEmail("testEmail");
        uMapper.insert(vo);
        log.info(vo);
    }

    @Test
    public void testGetList(){
        for(UserVo vo:uMapper.getList()){
            log.info(vo);
        }
    }

    @Test
    public void testSelect(){
        UserVo vo = new UserVo();
        vo.setUNo(1L);
        UserVo result = uMapper.select(vo);
        log.info(result);
    }

    @Test
    public void testSelectKey(){
        UserVo vo = new UserVo();
        vo.setUId("testId2");
        Long key = uMapper.selectKey(vo);
        log.info(key);
    }

    @Test
    public void testUpdate(){
        UserVo vo = new UserVo();
        vo.setUNo(2L);
        vo.setUId("testId1");
        int result = uMapper.update(vo);
        log.info(result);
    }

    @Test
    public void testDelete(){
        UserVo vo = new UserVo();
        vo.setUNo(1L);
        int result = uMapper.delete(vo);
        log.info(result);
    }


}
