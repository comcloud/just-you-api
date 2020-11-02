package com.cloud.api.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HttpUtil;
import com.cloud.api.bean.entity.Tag;
import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskSetTag;
import com.cloud.api.mapper.PublishMapper;
import com.cloud.api.service.PublishService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/30 8:45
 */
@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    private PublishMapper publishMapper;

    @Override
    public void saveReleaseInfo(String info) {
        JsonNode node = null;
        Task task = new Task();
        try {
            node = new ObjectMapper().readTree(info);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert node != null;
        final String recruitingNumber = node.findPath("recruiting_number").toString().replace("\"", "").trim();
        final String needNumber = node.findPath("need_number").toString().replace("\"", "");
        final String money = node.findPath("money").toString().replace("\"", "");
        final String startTime = node.findPath("start_time").toString().replace("\"", "");
        final String endTime = node.findPath("end_time").toString().replace("\"", "");
        final JsonNode base64 = node.findPath("data").findPath("base64");
        final ObjectNode dataObject = JsonNodeFactory.instance.objectNode();
        AtomicInteger count = new AtomicInteger();
        if (base64.isArray()) {
            base64.forEach(b->{
                final String url = b.findPath("url").toString();
                final String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("static")).getPath() + "/upload-image/";
                String fileName = LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss"))+"_"+UUID.randomUUID().toString()+".jpg";
                Base64.decodeToFile(url.replace("\"",""),new File(path+"/"+fileName));
                dataObject.put("url"+count.get(),"https://mrkleo.top/justyou/static/upload-image/"+fileName);
                count.getAndIncrement();
            });
        }

        final String[] s = startTime.split(" ");
        final String[] split = endTime.split(" ");
        final String openId = node.findPath("open_id").toString().replace("\"", "");
        task.setUserId(publishMapper.selectUserIdFromOpenId(openId))
                .setTaskDescription(node.findPath("task_description").toString().replace("\"", ""))
                .setRecruitingNumber(Integer.parseInt(recruitingNumber.contains("不限") ? "-1" : recruitingNumber))
                .setNeedNumber(Integer.parseInt(needNumber.contains("不限") ? "-1" : needNumber))
                .setData(dataObject.toString())
                .setClassId(Long.parseLong(node.findPath("class_id").toString().replace("\"", "")))
                .setCharge(Integer.parseInt(node.findPath("charge").toString().replace("\"", "")))
                .setMoney(Double.parseDouble("".equals(money) ? 0 + "" : money))
                .setReleaseTime(LocalDateTime.now(ZoneId.systemDefault()))
                .setTaskTitle(node.findPath("task_title").toPrettyString().replace("\"", ""))
                .setTraffic(0)
                .setStartTime(LocalDateTime.parse(s[0] + "T" + s[1] + ":00"))
                .setEndTime("".equals(endTime) ? null : LocalDateTime.parse(split[0] + "T" + split[1] + ":00"))
                .setState(1);
        long taskId = publishMapper.insertTask(task);
        final JsonNode tag = node.findPath("tag");
        //如何标签是多个，然后使用的数组传递过来的
        if (tag.isArray()) {
            for (JsonNode jsonNode : tag) {
                TaskSetTag taskSetTag = new TaskSetTag();
                taskSetTag.setTaskId(taskId);
                taskSetTag.setTagId(jsonNode.asLong());
                publishMapper.insertTaskSetTag(taskSetTag);
            }
        } else if(!"".equals(tag.toString().trim())){
            //如何只是传递一个字符串过来记录tag值
            TaskSetTag taskSetTag = new TaskSetTag();
            taskSetTag.setTaskId(taskId);
            taskSetTag.setTagId(tag.asLong());
            publishMapper.insertTaskSetTag(taskSetTag);
        }

    }

    @Override
    public List<Tag> getAllTag() {
        //        Map<Integer, String> map = new HashMap<>();
//        tagList.forEach(tag -> map.put(tag.getTagId(), tag.getTagName()));
        return publishMapper.selectAllTag();
    }
    @Override
    public String getKey(String jsCode) {
        String baseUrl = "https://api.weixin.qq.com/sns/jscode2session" + "?js_code=" + jsCode;
        String appid = "wx45847f8c326518ee";
        String secret = "2f93f9e0028618cb7adfb001325b3515";
        String grantType = "authorization_code";
        return HttpUtil.get(baseUrl + "&appid=" + appid + "&secret=" + secret + "&grant_type=" + grantType);
    }
}
