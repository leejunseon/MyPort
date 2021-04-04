package com.myport.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CountryVo {
    private Long cNo;
    private String uId;
    private String cName;
    private Long cRatio;
    private String cRegdate;
    private String cUpdatedate;
}
