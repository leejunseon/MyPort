package com.myport.service;

import com.myport.domain.UserVo;
import com.myport.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserMapper mapper;

    @Override
    public void registerUser(UserVo user) {
        mapper.insert(user);
    }

    @Override
    public List<UserVo> retrieveUser() {
        return mapper.getList();
    }

    @Override
    public UserVo getUser(UserVo user) {
        return mapper.select(user);
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
