package com.myport.domain;

import lombok.Data;

import java.util.Date;

@Data
public class AssetVo {
    private Long aNo;
    private Long uNo;
    private String aName;
    private Long aRatio;
    private String aRegdate;
    private String aUpdatedate;
}
