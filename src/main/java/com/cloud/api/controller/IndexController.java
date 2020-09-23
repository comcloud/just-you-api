package com.cloud.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HP
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/admin")
    public String admin(){
        return "/admin/dashboard";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "/admin/page-login";
    }

}
