package com.myport.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserVo {
    private Long uPk;
    private String uId;
    private String uPw;
    private String uName;
    private String uEmail;
    private Date uRegdate;
    private Date uUpdatedate;
}
