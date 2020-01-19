package com.zjw.oa.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Gsgg {

  private int ggId;
  private String ggTitle;
  private String ggNr;
  @DateTimeFormat(pattern ="yyyy-MM-dd")
  private Date ggTime;
  private int isZs;

}
