package com.zjw.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjw.oa.entity.Gsgg;
import com.zjw.oa.entity.Xmjd;
import com.zjw.oa.service.GgService;
import com.zjw.oa.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/gsxx")
@Slf4j
public class GgController {

    @Resource
    private GgService ggService;

    /**
     * 公告
     *
     * @return
     */
    @RequestMapping(value = "/gsgg")
    @ResponseBody
    public JSONArray getGgList() {
        List<Gsgg> list = ggService.getGgList();
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    /**
     * 项目进度
     *
     * @return
     */
    @RequestMapping(value = "/xmjd")
    @ResponseBody
    public JSONArray getXmList() {
        List<Xmjd> list = ggService.getxmList();
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @GetMapping(value = "/addGg")
    public JSONObject add(Gsgg gsgg) {
        JSONObject jsonObject = JSON.parseObject("{success:true,msg:\"提交成功！\"}");
        try {
            gsgg.setIsZs(1);
            ggService.add(gsgg);
        } catch (Exception e) {
            log.info("添加公告失败:" + e);
            return JSON.parseObject("{success:false,msg:\"提交失败！\"}");
        }
        return jsonObject;

    }


    @GetMapping(value = "/delGg")
    public JSONObject delete(Gsgg gsgg) {
        JSONObject jsonObject = JSON.parseObject("{success:true,msg:\"提交成功！\"}");
        try {
            gsgg.setIsZs(0);
            ggService.delete(gsgg);
        } catch (Exception e) {
            log.info("删除公告失败:" + e);
            return JSON.parseObject("{success:false,msg:\"提交失败！\"}");
        }
        return jsonObject;

    }
}
