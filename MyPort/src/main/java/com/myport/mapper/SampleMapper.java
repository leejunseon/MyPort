package com.myport.mapper;


import org.apache.ibatis.annotations.Select;

public interface SampleMapper {

    @Select("SELECT SYSDATE FROM DUAL")
    public String getTime();
}
