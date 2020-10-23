package com.cloud.api.service.BlogThehall.Impl;

import com.cloud.api.bean.vo.BlogVo;
import com.cloud.api.mapper.BlogThehall.BlogThehallMapper;
import com.cloud.api.service.BlogThehall.BlogThehallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public List<BlogVo> getPushAllBlog() {
        List<BlogVo> blogVos = blogThehallMapper.selectPushAllBlog();
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
}
