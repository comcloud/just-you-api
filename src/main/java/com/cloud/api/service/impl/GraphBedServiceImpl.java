package com.cloud.api.service.impl;

import com.cloud.api.service.GraphBedService;
import com.cloud.api.util.algorithm.ExtractImageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/27 10:30
 */
@Service
@SuppressWarnings("all")
public class GraphBedServiceImpl implements GraphBedService {
    @Override
    public String upload(String body) {
        try {
            String basePath = "/home/justyou/upload-file/upload-image/";
            //这一部分用来作为上传时间然后用来分文件夹的，现在没有使用，而是直接都放到上面的目录中
//            String nowTime = LocalDate.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//            final String[] split = nowTime.split("-");
//            String realPath = basePath + "/" + split[0] + "/" + split[1] + "/" + split[2];
//            final File dir = new File(realPath);
//            if (!dir.exists() && !dir.isDirectory()) {
//                dir.mkdirs();
//            }
            String decode = URLDecoder.decode(body, "utf-8");
            JsonNode node = new ObjectMapper().readTree(decode).findPath("image");
            String fileName = UUID.randomUUID().toString() + ".jpg";
            ExtractImageUtil.decoderBase64ToFile(node.toString().replace(" ", "+"), new File(basePath,fileName));
            return JsonNodeFactory.instance.objectNode().put("image_url", "https://mrkleo.top/justyou/upload-image/" + fileName).toPrettyString();
        } catch (UnsupportedEncodingException | JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
