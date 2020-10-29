package com.cloud.api.service.BlogThehall.Impl;

import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.bean.vo.BlogVo;
import com.cloud.api.mapper.BlogThehall.BlogThehallMapper;
import com.cloud.api.mapper.VXUser.VXUserMapper;
import com.cloud.api.service.BlogThehall.BlogThehallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

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
            blogVo.setIfLike(blogThehallMapper.selectIFAddLike(openId, blogVo.getId())>0);
            blogVo.setLikeCount(blogThehallMapper.selectLikeCountByDynamicId(blogVo.getId()));
            blogVo.setAttention(vxUserMapper.SelectISTtentionUser(openId,blogVo.getUser().getOpenId())>0);
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
    public Dynamic getDynamicDetails(Long dynamic_id,String openId) {
        blogThehallMapper.dynamicViewsAdd1(dynamic_id);
        Dynamic dynamics = blogThehallMapper.selectDynamicDetails(dynamic_id);
        dynamics.setAttention(vxUserMapper.SelectISTtentionUser(openId,dynamics.getOpenId())>0);
        dynamics.setIfLike(blogThehallMapper.selectIFAddLike(openId, dynamics.getDynamicId())>0);
        return dynamics;
    }
}
