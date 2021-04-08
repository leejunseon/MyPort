package com.myport.service;

import com.myport.domain.UserVo;

import java.util.List;

public interface UserService {

    public void registerUser(UserVo user);

    public List<UserVo> retrieveUser();

    public UserVo getUser(UserVo user);

    public int modifyUser(UserVo user);

    public int removeUser(UserVo user);

}
