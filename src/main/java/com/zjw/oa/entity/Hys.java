package com.zjw.oa.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Hys {

  private Integer id;
  private String hysbh;
  private String hyszt;
  private String bz;
  private String status;
  @DateTimeFormat(pattern ="yyyy-MM-dd")
  private Date useTime;



}
