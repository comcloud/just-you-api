package com.cloud.api.service.impl;

import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskOrder;
import com.cloud.api.mapper.OrderMapper;
import com.cloud.api.service.OrderService;
import com.cloud.api.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/14 21:47
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * task:订单金额、订单给定时间
     * order:订单编号、订单状态、订单发布时间
     * user:接单用户open_id、
     * 报名人数（根据任务id查询）、订单开发周期（根据任务时间）
     *
     * @return
     */
    @Override
    public List<ModelUtil<TaskOrder, ModelUtil<Task, ModelUtil<String, ModelUtil<Integer, Integer>>>>> getAllOrderData() {
        List<Task> tasks = orderMapper.selectTaskData();
        List<TaskOrder> taskOrders = orderMapper.selectOrderData();
        List<ModelUtil<TaskOrder, ModelUtil<Task, ModelUtil<String, ModelUtil<Integer, Integer>>>>> modelUtil = new ArrayList<>();
        //第一步把task存起来
        tasks.forEach(task -> {
            Integer numberOfApplicants = orderMapper.selectNumberFromTaskId(task.getId());
            final Duration between = Duration.between(task.getEndTime(), task.getStartTime());
            Integer developmentCycle = Math.toIntExact(between.toHours() / 24);
            ModelUtil<TaskOrder, ModelUtil<Task, ModelUtil<String, ModelUtil<Integer, Integer>>>> tempTaskOrderNull = new ModelUtil<>();
            ModelUtil<Task, ModelUtil<String, ModelUtil<Integer, Integer>>> value = new ModelUtil<>();
            ModelUtil<String, ModelUtil<Integer, Integer>> tempOpenIdNull = new ModelUtil<>();
            ModelUtil<Integer, Integer> integerModel = new ModelUtil<>();
            integerModel.setFirstValue(numberOfApplicants).setLastValue(developmentCycle);
            tempOpenIdNull.setFirstValue("").setLastValue(integerModel);
            value.setFirstValue(task).setLastValue(tempOpenIdNull);
            tempTaskOrderNull.setFirstValue(null).setLastValue(value);
            modelUtil.add(tempTaskOrderNull);
        });
        //第二步将task order值存入
        taskOrders.forEach(taskOrder -> {
            for (int i = 0; i < taskOrders.size(); i++) {
                if (modelUtil.get(i).getLastValue().getFirstValue().getId().equals(taskOrder.getTaskId())){
                    modelUtil.get(i).setFirstValue(taskOrder);
                    modelUtil.get(i).getLastValue().getLastValue().setFirstValue(orderMapper.selectOpenIdFromUserId(taskOrder.getOrderUserId()));
                    break;
                }
            }
        });
        return modelUtil;
    }
}
