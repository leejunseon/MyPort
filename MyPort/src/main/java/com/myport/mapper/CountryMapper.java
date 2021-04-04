package com.myport.mapper;

import com.myport.domain.CountryVo;

import java.util.List;

public interface CountryMapper {

    public void insert(CountryVo country);

    public List<CountryVo> getList();

}
