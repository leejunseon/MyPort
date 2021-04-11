package com.myport.service;

import com.myport.domain.UserVo;
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
public class UserServiceTests {

    @Setter(onMethod_ = @Autowired)
    private UserService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegister() {
        UserVo vo = new UserVo();
        vo.setUId("testId2");
        vo.setUPw("testPw");
        vo.setUName("testName");
        vo.setUEmail("testEmail");
        service.registerUser(vo);
        log.info(vo);
    }

    @Test
    public void testRetrieveUser() {
        for (UserVo vo : service.retrieveUser()) {
            log.info(vo);
        }
    }

    @Test
    public void testGetUser() {
        UserVo vo = new UserVo();
        vo.setUNo(3L);
        UserVo result = service.getUser(vo);
        log.info(result);
    }

    @Test
    public void testUpdate() {
        UserVo vo = new UserVo();
        vo.setUNo(3L);
        vo.setUId("testId1_update");
        int result = service.modifyUser(vo);
        log.info(result);
    }

    @Test
    public void testDelete() {
        UserVo vo = new UserVo();
        vo.setUNo(3L);
        int result = service.removeUser(vo);
        log.info(result);
    }

}