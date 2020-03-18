package com.zjw.oa.mapper;

import com.zjw.oa.entity.Hys;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeetingRoomMapper {
    Integer agree(Hys hys);
    Integer add(Hys hys);


}
