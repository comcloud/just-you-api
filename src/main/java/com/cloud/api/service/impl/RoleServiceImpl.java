package com.cloud.api.service.impl;

import com.cloud.api.bean.entity.Admin;
import com.cloud.api.mapper.RoleMapper;
import com.cloud.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/19 23:37
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Admin> getAllAdmin() {
        return roleMapper.selectAllAdmin();
    }

    @Override
    public boolean changeAdminStatus(Admin admin) {
        return roleMapper.updateAdminStatus(admin);
    }
}
