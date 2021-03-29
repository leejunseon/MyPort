package com.myport.domain;

import lombok.Data;

import java.util.Date;

@Data
public class StockVo {
    private Integer sPk;
    private Integer uPk;
    private Integer fPk;
    private Integer cPk;
    private String sName;
    private Long sPrice;
    private Integer sNum;
    private Date sRegdate;
    private Date sUpdatedate;
}
