package com.myport.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CountryVo {
    private Long cPk;
    private Long uPk;
    private String cName;
    private int cRatio;
    private Date cRegdate;
    private Date cUpdatedate;
}
