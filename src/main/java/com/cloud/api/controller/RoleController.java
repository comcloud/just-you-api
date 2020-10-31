package com.cloud.api.controller;

import com.cloud.api.bean.entity.Admin;
import com.cloud.api.service.RoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/19 23:14
 */
@Controller
@ApiIgnore
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/toAdminPage")
    public String toAdminPage(Model model){
        model.addAttribute("admins",roleService.getAllAdmin());
        return "X-admin/admin/admin-list";
    }

    @ResponseBody
    @RequestMapping(value = "changeRoleStatus",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String changeRoleStatus(@RequestParam(value = "status") boolean status,
                                   @RequestBody String aid) throws JsonProcessingException, UnsupportedEncodingException {
        Admin admin = new Admin();
        final String decode = URLDecoder.decode(aid, "utf-8");
        admin.setAid(Integer.parseInt(decode.substring(decode.indexOf("=") + 1).replace("\"",""))).setStatus(status);
        return JsonNodeFactory.instance.objectNode().put("success",roleService.changeAdminStatus(admin)).toPrettyString();
    }

}
