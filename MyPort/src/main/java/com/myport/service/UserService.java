package com.myport.service;

import com.myport.domain.UserVo;

import java.util.Map;

public interface UserService {

    public void registerUser(UserVo user);

    public Map<String,String> login(UserVo user);

    public int modifyUser(UserVo user);

    public int removeUser(UserVo user);

}
