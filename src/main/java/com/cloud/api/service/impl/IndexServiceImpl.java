package com.cloud.api.service.impl;

import cn.hutool.http.HttpUtil;
import com.cloud.api.mapper.IndexMapper;
import com.cloud.api.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HP
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;
    @Override
    public boolean checkAdmin(String name, String password) {
        return indexMapper.selectAdmin(name,password);
    }


}
