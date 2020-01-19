package com.zjw.oa.mapper;

import com.zjw.oa.entity.Gsgg;
import com.zjw.oa.entity.Xmjd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GgMapper {
    List<Gsgg> getGgList();

    List<Xmjd> getxmList();

    Integer add(Gsgg gsgg);

    Integer delete(Gsgg gsgg);


}
