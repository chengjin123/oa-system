package com.zjw.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjw.oa.entity.Hys;
import com.zjw.oa.service.MeetingRoomService;
import com.zjw.oa.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/meeting/room")
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @GetMapping(value = "/agree")
    public JSONObject agree(Hys hys) {
        try {
            meetingRoomService.agree(hys);
        } catch (Exception e) {
            return JSON.parseObject("{success:false,msg:\"审批失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"审批成功！\"}");
    }

    @GetMapping(value = "/add")
    public JSONObject add(Hys hys) {
        try {
            meetingRoomService.add(hys);
        } catch (Exception e) {
            return JSON.parseObject("{success:false,msg:\"添加失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"添加成功！\"}");
    }


}
