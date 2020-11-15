package com.cloud.api.service.BlogThehall.Impl;

import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.bean.entity.Photo;
import com.cloud.api.bean.vo.BlogVo;
import com.cloud.api.bean.vo.UserVo;
import com.cloud.api.mapper.BlogThehall.BlogThehallMapper;
import com.cloud.api.mapper.VXUser.VXUserMapper;
import com.cloud.api.service.BlogThehall.BlogThehallService;
import com.cloud.api.util.algorithm.ExtractImageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/23-14:01
 */
@Service
public class BlogThehallServiceImpl implements BlogThehallService {
    @Autowired
    private BlogThehallMapper blogThehallMapper;
    @Autowired
    private VXUserMapper vxUserMapper;

    @Override
    public List<BlogVo> getPushAllBlog(String openId) {
        List<BlogVo> blogVos = blogThehallMapper.selectPushAllBlog();
        for (BlogVo blogVo : blogVos) {
            blogVo.setIfLike(blogThehallMapper.selectIFAddLike(openId, blogVo.getId()) > 0);
            blogVo.setLikeCount(blogThehallMapper.selectLikeCountByDynamicId(blogVo.getId()));
            blogVo.setAttention(vxUserMapper.SelectISTtentionUser(openId, blogVo.getUser().getOpenId()) > 0);
        }
        Collections.shuffle(blogVos);
        return blogVos;
    }

    @Override
    public boolean setPushBy1() {
        return true;
    }

    @Override
    public boolean setPushBy0() {
        return true;
    }

    @Transactional
    @Override
    public Dynamic getDynamicDetails(Long dynamic_id, String openId) {
        blogThehallMapper.dynamicViewsAdd1(dynamic_id);
        Dynamic dynamics = blogThehallMapper.selectDynamicDetails(dynamic_id);
        dynamics.setLikeCount(blogThehallMapper.selectLikeCountByDynamicId(dynamic_id));
        dynamics.setAttention(vxUserMapper.SelectISTtentionUser(openId, blogThehallMapper.selectOpenIdByDynamicId(dynamic_id)) > 0);
        dynamics.setIfLike(blogThehallMapper.selectIFAddLike(openId, dynamics.getDynamicId()) > 0);
        return dynamics;
    }

    @Override
    public void addDynamic(String dynamicData) {
        Dynamic dynamic = new Dynamic();
        List<Photo> photos = new ArrayList<>();
        try {
            final JsonNode node = new ObjectMapper().readTree(dynamicData);
            final String content = node.findPath("content").toString();
            final String openId = node.findPath("open_id").toString();
            UserVo userVo = new UserVo();
            userVo.setOpenId(openId.replace("\"",""));
            final JsonNode photoArray = node.findPath("photo");
            final LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
            if(photoArray.isArray()){
                photoArray.forEach(photo -> {
                    final String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("static")).getPath() + "/upload-image/";
                    final String base64 = photo.toString().replace("\"", "").trim().replace(" ", "+");
                    String fileName = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + "_" + openId.replace("\"","") + ".jpg";
                    ExtractImageUtil.decoderBase64ToFile(base64, new File(path,fileName));
                    final Photo p = new Photo();
                    p.setPhotoUrl("https://mrkleo.top/justyou/static/upload-image/" + fileName);
                    photos.add(p);
                });
            }
            dynamic.setDynamicId((long) 0).setDynamicTitle(content.substring(0, 6)).setDynamicContent(content)
                    .setDynamicViews((long) 0).setDynamicComment(1).setDynamicDeleted(0).setDynamicTime(now)
                    .setDynamicUpdateTime(new Date()).setdAbstract(content.substring(0, 7)).setLikeCount((long) 0)
                    .setUser(userVo).setPhoto(null).setDynamicTags(null);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        blogThehallMapper.insertDynamic(dynamic);
        photos.forEach(photo -> blogThehallMapper.insertPhoto(photo));
    }
}
