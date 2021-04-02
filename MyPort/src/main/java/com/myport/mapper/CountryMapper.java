package com.myport.mapper;

import com.myport.domain.CountryVo;

import java.util.List;

public interface CountryMapper {

    public List<CountryVo> getList();

    public void insert(CountryVo country);

}
