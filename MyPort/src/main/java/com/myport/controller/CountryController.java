package com.myport.controller;

import com.myport.domain.CountryDtoList;
import com.myport.domain.CountryVo;
import com.myport.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/country/*")
@AllArgsConstructor
public class CountryController {

    private CountryService service;

    @PostMapping("/register")
    public String registerCountries(CountryDtoList countries, RedirectAttributes rttr){
        for(CountryVo country : countries.getCountryList()){
            service.registerCountry(country);
        }

        rttr.addFlashAttribute("result", "저장되었습니다.");
        return "(투자비율 설정화면)";
    }

}
