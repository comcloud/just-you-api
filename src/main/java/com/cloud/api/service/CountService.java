package com.cloud.api.service;

import com.cloud.api.util.Result;

import java.util.Map;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/8-20:24
 */
public interface CountService {
    int SelecttaskCount(int id);
    int  selectUserCount();
    int selectDynamiccount();
    int sekectTaskOrder3();
    Result<Map<String,Object>> get7CountUser();
}
