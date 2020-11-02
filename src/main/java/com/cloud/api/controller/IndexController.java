package com.cloud.api.controller;
import com.cloud.api.bean.entity.Admin;
import com.cloud.api.service.IndexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
/**
 * @author HP
 */
@Controller
@ApiIgnore
public class IndexController {

    @Autowired
    private IndexService indexService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin", method = {RequestMethod.POST, RequestMethod.GET})
    public String admin(HttpServletRequest request) {
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
    @RequestMapping(value = {"/", "index"})
    public String index() {
        return "X-admin/index";
    }

    @RequestMapping(value = "/exception")
    public String exception(){
        return "X-admin/error";
    }


    /**
     * 登出操作
     * @param request
     * @return
     */
    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("admin");
        return "X-admin/login";
    }
}

