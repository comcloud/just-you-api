package com.cloud.api.service;

import com.cloud.api.bean.entity.Task;
import com.cloud.api.util.ModelUtil;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/6 18:06
 */
public interface ProjectService {
    List<ModelUtil<Task,ModelUtil<String,String>>> getAllTaskData();
}
