package com.myport.service;


import com.myport.domain.CountryVo;
import com.myport.mapper.CountryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService{

    private CountryMapper mapper;

    @Override
    public void registerCountry(CountryVo country) {
        mapper.insert(country);
    }

    @Override
    public CountryVo getCountry(CountryVo country) {
        return mapper.select(country);
    }

    @Override
    public int modifyCountry(CountryVo country) {
        return mapper.update(country);
    }

    @Override
    public int removeCountry(CountryVo country) {
        return mapper.delete(country);
    }
}
