package com.cloud.api.controller;

import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskOrder;
import com.cloud.api.service.OrderService;
import com.cloud.api.util.ModelUtil;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/9 11:27
 *
 * task:订单金额、订单给定时间
 * order:订单编号、订单状态、订单发布时间
 * user:接单用户open_id、
 * 报名人数、订单开发周期
 * ModelUtil<Order,ModelUtil<Task,ModelUtil<String,ModelUtil<String,String>>>>
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @return 跳转到订单页面
     */
    @RequestMapping(value = "/order_list")
    public String orderList(Model model) {
        List<ModelUtil<TaskOrder,ModelUtil<Task,ModelUtil<String, ModelUtil<Integer,Integer>>>>> modelUtil = orderService.getAllOrderData();
        model.addAttribute("orderObject", modelUtil);
        return "/X-admin/order/order-list1";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String deleteList(@RequestBody Integer[] list) {
        return JsonNodeFactory.instance.objectNode().put("success", orderService.removeList(list)).toPrettyString();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTaskOrder", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String deleteTask(@RequestBody Integer id) {
        return JsonNodeFactory.instance.objectNode().put("success", orderService.removeTaskOrderById(id)).toPrettyString();
    }
}
