package com.myport.domain;

import lombok.Data;

import java.util.Date;

@Data
public class StockVo {
    private Long sNo;
    private String uId;
    private String cName;
    private String fName;
    private String sName;
    private Long sPrice;
    private Long sNum;
    private String sRegdate;
    private String sUpdatedate;
}
