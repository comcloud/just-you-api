package com.cloud.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author HP
 */
@Controller
@ApiIgnore
public class IndexController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin", method = {RequestMethod.POST, RequestMethod.GET})
    public String admin() {
        return "X-admin/index";

    }

    @RequestMapping(value = "/login/error")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception =
                (AuthenticationException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return 登录请求
     */
    @RequestMapping(value = "/toLogin")
    public String login() {
        return "X-admin/login";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"/admin"})
    public String index() {
        return "X-admin/index";
    }

    @RequestMapping(value = "/exception")
    public String exception(){
        return "X-admin/error";
    }


    /**
     * 登出操作
     * @param request 用来获取session
     * @return 返回登录界面
     */
    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("admin");
        return "X-admin/login";
    }


    @RequestMapping(value ={"/" ,"/index"})
    public String goToOfficialWeb(){
        return "official-website/bl-first-index";
    }
    @RequestMapping(value = "/list")
    public String goToList(){
        return "official-website/bl-aritical-list";
    }
    @RequestMapping(value = "/about")
    public String goAbout1(){
        return "official-website/bl-about";
    }
    @RequestMapping(value = "/about2")
    public String goToAbout2(){
        return "official-website/bl-about2";
    }

}

