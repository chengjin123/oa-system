package com.zjw.oa.service.impl;

import com.zjw.oa.entity.Hys;
import com.zjw.oa.mapper.MeetingRoomMapper;
import com.zjw.oa.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomServiceImpl  implements MeetingRoomService {
    @Autowired
    MeetingRoomMapper meetingRoomMapper;
    @Override
    public Integer agree(Hys hys) {
        return meetingRoomMapper.agree(hys);
    }

    @Override
    public Integer add(Hys hys) {
        return meetingRoomMapper.add(hys);
    }


}
