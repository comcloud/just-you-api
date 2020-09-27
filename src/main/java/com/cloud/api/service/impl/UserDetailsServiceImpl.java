package com.cloud.api.service.impl;

import com.cloud.api.bean.entity.Admin;
import com.cloud.api.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/9/27 11:40
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IndexMapper indexMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = indexMapper.selectAdminByEmail(email);
        if(admin == null){
            return null;
        }else{
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(admin.getAdminEmail(), passwordEncoder.encode(admin.getAdminPassword()), authorities);
        }
    }
}
