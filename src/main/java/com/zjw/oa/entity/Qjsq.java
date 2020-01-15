package com.zjw.oa.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Qjsq {

    private long qjId;
    private String qjyy;
    private String qjms;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date ksTime;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date jsTime;
    private String qjzt;
    private int userId;
    private String userName;

}
