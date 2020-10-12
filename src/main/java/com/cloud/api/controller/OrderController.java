package com.cloud.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/9 11:27
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {
    /**
     * @return 跳转到订单页面
     */
    @RequestMapping(value = "/order_list")
    public String orderList() {
        return "/X-admin/order/order-list1";
    }
}
