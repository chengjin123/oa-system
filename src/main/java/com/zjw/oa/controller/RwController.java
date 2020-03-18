package com.zjw.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjw.oa.entity.Rw;
import com.zjw.oa.entity.Rz;
import com.zjw.oa.service.RwService;
import com.zjw.oa.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/rwxx")
@Slf4j
public class RwController {

    @Resource
    private RwService rwService;


    /**
     * 查看自己的工作任务 - 列表
     *
     * @param rw
     * @return
     */
    @RequestMapping(value = "/myRw")
    @ResponseBody
    public JSONArray myRw(Rw rw) {
        List<Rw> list = rwService.myRw(rw);
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    /**
     * 查看自己的工作任务 - 详情
     *
     * @param rw
     * @return
     */
    @RequestMapping(value = "/rwXq")
    @ResponseBody
    public JSONObject rwXq(Rw rw) {
        Rw rw1 = rwService.rwXq(rw);
        String jsonStr = JsonUtil.serialize(rw1);
        return JSON.parseObject(jsonStr);
    }

    /**
     * 删除任务 - 权限
     *
     * @param rw
     * @return
     */
    @RequestMapping(value = "/delRw")
    @ResponseBody
    public JSONObject delRw(Rw rw) {
        try {
            rwService.delRw(rw);
        } catch (Exception e) {
            log.info("删除任务失败：" + e);
            return JSON.parseObject("{success:false,msg:\"删除任务失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"删除任务成功！\"}");
    }

    /**
     * 修改任务 - 权限
     *
     * @param rw
     * @return
     */
    @RequestMapping(value = "/updateRw")
    @ResponseBody
    public JSONObject updateRw(Rw rw) {
        try {
            rwService.updateRw(rw);
        } catch (Exception e) {
            return JSON.parseObject("{success:false,msg:\"编辑任务失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"编辑任务成功！\"}");
    }

    /**
     * 添加任务 - 权限
     *
     * @param rw
     * @return
     */
    @RequestMapping(value = "/addRw")
    @ResponseBody
    public JSONObject addRw(Rw rw) {
        try {
            rw.setIsComplete(0);
            rwService.addRw(rw);
        } catch (Exception e) {
            log.info("添加任务失败：" + e);
            return JSON.parseObject("{success:false,msg:\"添加任务失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"添加任务成功！\"}");
    }

    /**
     * 查看日志 - 列表
     *
     * @return
     */
    @RequestMapping(value = "/rzList")
    @ResponseBody
    public JSONArray rzList(String rzTime) {

        List<Rz> list = rwService.rzList(rzTime);
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    /**
     * 添加日志
     *
     * @param rz
     * @return
     */
    @RequestMapping(value = "/addRz")
    @ResponseBody
    public JSONObject addRz(Rz rz) {
        try {
            rwService.addRz(rz);
        } catch (Exception e) {
            return JSON.parseObject("{success:false,msg:\"添加日志失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"添加日志成功！\"}");
    }


    @RequestMapping(value = "/batchremove")
    @ResponseBody
    public JSONObject batchremove(Rw rw) {
        try {
            rw.setIsComplete(1);
            rwService.batchremove(rw);
        } catch (Exception e) {
            log.info("删除任务失败:" + e);
            return JSON.parseObject("{success:false,msg:\"删除任务失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"删除任务成功！\"}");
    }


    public static void main(String[] args) throws ParseException {
        String string = "2016-10-24 21:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(string);
        System.out.println(date.getTime());
        java.sql.Date date2 = new java.sql.Date(date.getTime());
        System.out.println(date2);
    }
}
