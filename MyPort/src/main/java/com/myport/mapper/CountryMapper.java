package com.myport.mapper;

import com.myport.domain.CountryVo;

import java.util.List;

public interface CountryMapper {

    public void insert(CountryVo country);

    public List<CountryVo> getList();

    public CountryVo select(CountryVo country);

    public Long selectKey(CountryVo country);

    public int update(CountryVo country);

    public int delete(CountryVo country);

}
