package com.myport.service;

import com.myport.domain.CountryVo;

public interface CountryService {

    public void registerCountry(CountryVo country);

    public CountryVo getCountry(CountryVo country);

    public int modifyCountry(CountryVo country);

    public int removeCountry(CountryVo country);

}
