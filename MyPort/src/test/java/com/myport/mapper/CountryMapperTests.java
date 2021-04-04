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
        CountryVo vo = new CountryVo();
        UserVo user = new UserVo();
        user.setUName("testId1");
        //vo.setUId(cMapper.selectKey(user));
    }

    @Test
    public void testGetList(){
        /*for(CountryVo vo:uMapper.getList()){
            log.info(vo);
        }*/
    }

}
