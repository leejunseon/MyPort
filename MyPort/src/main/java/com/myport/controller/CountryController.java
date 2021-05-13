package com.myport.controller;

import com.myport.domain.CountryDtoList;
import com.myport.domain.CountryVo;
import com.myport.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
@AllArgsConstructor
public class CountryController {

    private CountryService service;

    @PostMapping("/register")
    public void registerCountries(CountryDtoList countries){
        for(CountryVo country : countries.getCountryList()){
            service.registerCountry(country);
        }

        //return ?
    }

}
