package com.cloud.api.service;

import com.cloud.api.bean.entity.Admin;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/19 23:36
 */
public interface RoleService {

    List<Admin> getAllAdmin();

    boolean changeAdminStatus(Admin admin);
}
