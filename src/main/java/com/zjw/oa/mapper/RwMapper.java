package com.zjw.oa.mapper;


import com.zjw.oa.entity.Rw;
import com.zjw.oa.entity.Rz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RwMapper {

    List<Rw> myRw(Rw rw);

    Rw rwXq(Rw rw);

    void delRw(Rw rw) throws Exception;

    void updateRw(Rw rw) throws Exception;

    void addRw(Rw rw) throws Exception;

    List<Rz> rzList(@Param("rzTime") String rz);

    void addRz(Rz rz) throws Exception;

    void batchremove(Rw rw);

}
