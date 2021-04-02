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
    private UserMapper mapper;

    @Test
    public void testGetList(){
        for(UserVo vo:mapper.getList()){
            log.info(vo);
        }
    }

    @Test
    public void testInsert(){
        UserVo vo = new UserVo();
        vo.setUId("testId");
        vo.setUPw("testPw");
        vo.setUName("testName");
        vo.setUEmail("testEmail");
        mapper.insert(vo);
        log.info(vo);
    }

}
