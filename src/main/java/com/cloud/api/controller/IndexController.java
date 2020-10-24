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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
/**
 * @author HP
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin", method = {RequestMethod.POST, RequestMethod.GET})
    public String admin(HttpServletRequest request) {
        return "X-admin/index";

    }

    /**
     * 验证管理员登录
     *
     * @param loginInfo 管理员登录信息
     * @return 验证信息
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String loginCheck(@RequestBody String loginInfo,
                             HttpServletRequest request) throws IOException {
        String decode = URLDecoder.decode(loginInfo, "utf-8");
        JsonNode node = new ObjectMapper().readTree(decode.substring(decode.indexOf("{")));
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        String email = node.findPath("email").toString().replace("\"", "");
        String password = node.findPath("password").toString().replace("\"", "");
        boolean result = indexService.checkAdmin(email, password);
        if (result) {
            request.getSession().setAttribute("admin", new Admin(0, email, password,"","",null,true,1));
        } else {
            request.getSession().removeAttribute("admin");
        }
        objectNode.put("success", result);
        return objectNode.toPrettyString();
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

