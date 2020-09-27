package com.cloud.api.controller;

import com.cloud.api.bean.entity.Admin;
import com.cloud.api.service.IndexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * @author HP
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/admin")
    public String admin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Optional<Object> admin = Optional.ofNullable(session.getAttribute("admin"));
        if (admin.isPresent()) {
            return "/admin/dashboard";
        } else {
            return "/admin/page-login";
        }

    }
    /**
     * 验证管理员登录
     * @param loginInfo 管理员登录信息
     * @return 验证信息
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String loginCheck(@RequestBody String loginInfo,
                             HttpServletRequest request) throws JsonProcessingException {
        String decode = URLDecoder.decode(loginInfo, StandardCharsets.UTF_8);
        JsonNode node = new ObjectMapper().readTree(decode.substring(decode.indexOf("{")));
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        String email = node.findPath("email").toString().replace("\"","");
        String password = node.findPath("password").toString().replace("\"","");
        boolean result = indexService.checkAdmin(email, password);
        if(result){
            request.getSession().setAttribute("admin",new Admin(0,email,password));
        }else{
            request.getSession().removeAttribute("admin");
        }
        objectNode.put("success", result);
        return objectNode.toPrettyString();
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "/admin/page-login";
    }


    @RequestMapping(value = {"/","index"})
    public String index(){
        return "/admin/dashboard";
    }

    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return "/admin/page-login";
    }
}
