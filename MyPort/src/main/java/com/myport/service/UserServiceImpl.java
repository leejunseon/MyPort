package com.myport.service;

import com.myport.domain.UserVo;
import com.myport.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserMapper mapper;

    @Override
    public void registerUser(UserVo user) {
        mapper.insert(user);
    }

    @Override
    public Map<String,String> login(UserVo user){
        UserVo resultVo = mapper.select(user);
        Map<String,String> resultMap = new HashMap<>();
        if(resultVo==null){
            resultMap.put("result","fail");
            resultMap.put("url","/user/login");
        }else{
            resultMap.put("result",resultVo.getUId());
            resultMap.put("url","/item/list");
        }
        return resultMap;
    }

    @Override
    public int modifyUser(UserVo user) {
        return mapper.update(user);
    }

    @Override
    public int removeUser(UserVo user) {
        return mapper.delete(user);
    }
}
