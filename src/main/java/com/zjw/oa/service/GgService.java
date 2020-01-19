package com.zjw.oa.service;

import com.zjw.oa.entity.Gsgg;
import com.zjw.oa.entity.Xmjd;

import java.util.List;


public interface GgService {


    List<Gsgg> getGgList();

    List<Xmjd> getxmList();

    void add(Gsgg gsgg);

    void delete(Gsgg gsgg);

}
