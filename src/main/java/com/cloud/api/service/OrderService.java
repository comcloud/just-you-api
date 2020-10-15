package com.cloud.api.service;

import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskOrder;
import com.cloud.api.util.ModelUtil;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/14 21:46
 */
public interface OrderService {
    List<ModelUtil<TaskOrder, ModelUtil<Task, ModelUtil<String, ModelUtil<Integer, Integer>>>>> getAllOrderData();
}
