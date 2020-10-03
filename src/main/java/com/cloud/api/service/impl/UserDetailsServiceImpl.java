package com.cloud.api.service.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.cloud.api.bean.entity.Admin;
import com.cloud.api.config.security.CustomPasswordEncoder;
import com.cloud.api.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/9/27 11:40
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private PasswordEncoder passwordEncoder = new CustomPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = new Admin();
        try {

            final List<Entity> all = Db.use().findAll(Entity.create("admin").set("admin_email", email));
            all.forEach(entity -> admin.setAdminEmail(email).setAdminPassword(entity.getStr("admin_password")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Authentication authentication;
        if (email.contains("犀牛")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authentication = new UsernamePasswordAuthenticationToken(this.getClass().getName(), "ROLE_ADMIN", authorities);
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_NORMAL"));
            authentication = new UsernamePasswordAuthenticationToken(this.getClass().getName(), "ROLE_ADMIN", authorities);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new User(admin.getAdminEmail(), passwordEncoder.encode(admin.getAdminPassword()), authorities);


    }
}
