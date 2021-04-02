package com.myport.mapper;

import com.myport.domain.UserVo;

import java.util.List;

public interface UserMapper {

    public List<UserVo> getList();

    public void insert(UserVo user);

}
