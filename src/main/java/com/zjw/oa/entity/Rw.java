package com.zjw.oa.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class Rw {

  private int rwId;
  private List<Integer> ids;
  private String rwmc;
  private String rwms;
  @DateTimeFormat(pattern ="yyyy-MM-dd")
  private Date rwTime;
  private int jsUserId;
  private int fbUserId;
  private String jsUserName;
  private String fbUserName;
  private int jjcd;
  private int isComplete;
}
