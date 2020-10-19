package com.cloud.api.service.impl;

import com.cloud.api.bean.dto.OrderSearchObject;
import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskOrder;
import com.cloud.api.mapper.OrderMapper;
import com.cloud.api.service.OrderService;
import com.cloud.api.util.ModelUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
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
        List<TaskOrder> taskOrders = orderMapper.selectOrderData();
        return packing(taskOrders);
    }

    @Override
    public boolean removeTaskOrderById(Integer id) {
        return orderMapper.deleteTaskOrderById(id);
    }

    @Override
    public boolean removeList(Integer[] list) {
        for (Integer integer : list) {
            orderMapper.deleteTaskOrderById(integer);
        }
        return true;
    }

    @Override
    public List<ModelUtil<TaskOrder, ModelUtil<Task, ModelUtil<String, ModelUtil<Integer, Integer>>>>> search(JsonNode node) {
        final String firstMoneyStr = node.findPath("firstMoney").toString().replace("\"", "").trim();
        final String lastMoneyStr = node.findPath("lastMoney").toString().replace("\"", "").trim();
        final String releaseTimeStr = node.findPath("releaseTime").toString().replace("\"", "").trim();
        final String statusStr = node.findPath("status").toString().replace("\"", "").trim();
        LocalDateTime releaseTime = null;
        if (!"".equals(releaseTimeStr)) {
            releaseTime = LocalDateTime.parse(releaseTimeStr+"T00:00:00");
        }
        Double firstMoney = null;
        Double lastMoney = null;
        Integer status = null;
        if(!"".equals(firstMoneyStr)){
            firstMoney = Double.parseDouble(firstMoneyStr);
        }
        if(!"".equals(lastMoneyStr)){
            lastMoney = Double.parseDouble(lastMoneyStr);
        }
        if(!"".equals(statusStr)){
            status = Integer.parseInt(statusStr);
        }
        OrderSearchObject orderSearchObject = new OrderSearchObject();
        orderSearchObject.setFirstMoney(firstMoney).setLastMoney(lastMoney).setReleaseTime(releaseTime).setStatus(status);
        List<TaskOrder> taskOrders = orderMapper.selectOrderDataBySearch(orderSearchObject);
        return packing(taskOrders);
    }

    private List<ModelUtil<TaskOrder, ModelUtil<Task, ModelUtil<String, ModelUtil<Integer, Integer>>>>> packing(List<TaskOrder> taskOrders){
        List<ModelUtil<TaskOrder, ModelUtil<Task, ModelUtil<String, ModelUtil<Integer, Integer>>>>> modelUtil = new ArrayList<>();
        taskOrders.forEach(taskOrder -> {
            Task task = orderMapper.selectTaskIdFromId(taskOrder.getTaskId());
            Integer numberOfApplicants = orderMapper.selectNumberFromTaskId(task.getId());
            final Duration between = Duration.between(task.getStartTime(), task.getEndTime());
            Integer developmentCycle = Math.toIntExact(between.toDays());
            ModelUtil<TaskOrder, ModelUtil<Task, ModelUtil<String, ModelUtil<Integer, Integer>>>> onlyTaskOrder = new ModelUtil<>();
            ModelUtil<Task, ModelUtil<String, ModelUtil<Integer, Integer>>> orderAndTask = new ModelUtil<>();
            ModelUtil<String, ModelUtil<Integer, Integer>> orderAndTaskAndOpenId = new ModelUtil<>();
            ModelUtil<Integer, Integer> integerModel = new ModelUtil<>();
            integerModel.setFirstValue(numberOfApplicants).setLastValue(developmentCycle);
            String openId = orderMapper.selectOpenIdFromUserId(taskOrder.getOrderUserId());
            orderAndTaskAndOpenId.setFirstValue(openId).setLastValue(integerModel);
            orderAndTask.setFirstValue(task).setLastValue(orderAndTaskAndOpenId);
            onlyTaskOrder.setFirstValue(taskOrder).setLastValue(orderAndTask);
            modelUtil.add(onlyTaskOrder);
        });
        return modelUtil;
    }
}
