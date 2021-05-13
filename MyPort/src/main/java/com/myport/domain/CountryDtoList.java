package com.myport.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CountryDtoList {

    private List<CountryVo> countryList;

    public CountryDtoList(){
        countryList=new ArrayList<>();
    }
}
