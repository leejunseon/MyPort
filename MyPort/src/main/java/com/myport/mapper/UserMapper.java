package com.myport.mapper;

import com.myport.domain.UserVo;

import java.util.List;

public interface UserMapper {

    public void insert(UserVo user);

    public List<UserVo> getList();

    public UserVo select(UserVo user);

    public Long selectKey(UserVo user);

    public int update(UserVo user);

    public int delete(UserVo user);

}
