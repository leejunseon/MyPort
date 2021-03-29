package com.myport.domain;

import lombok.Data;

import java.util.Date;

@Data
public class FieldVo {
    private Long fPk;
    private Long uPk;
    private String fName;
    private Long fRatio;
    private Date fRegdate;
    private Date fUpdatedate;
}
