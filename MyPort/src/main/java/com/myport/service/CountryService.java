package com.myport.service;

import com.myport.domain.CountryVo;

import java.util.List;

public interface CountryService {

    public void registerCountry(CountryVo country);

    public List<CountryVo> retrieveCountry();

    public CountryVo getCountry(CountryVo country);

    public int modifyCountry(CountryVo country);

    public int removeCountry(CountryVo country);

}
