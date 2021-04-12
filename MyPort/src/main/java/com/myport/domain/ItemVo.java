package com.myport.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ItemVo {
    private Long iNo;
    private Long uNo;
    private Long cNo;
    private Long aNo;
    private String iName;
    private Long iPrice;
    private Long iNum;
    private String iRegdate;
    private String iUpdatedate;
}
