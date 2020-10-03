package com.cloud.api.config.security;

import com.cloud.api.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * @author HP
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService = new UserDetailsServiceImpl();
    /**
     * 请求配置
     *
     * @param http 请求http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/global/js/**","/global/css/**","/global/images/*","/global/fonts/**","/global/**/*.png","/global/**/*.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    //要前往的登录页面路径
                    .loginPage("/toLogin")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    //对应表单中的action中的值
                    .loginProcessingUrl("/login")
                    .failureUrl("/login/error")
                    .successForwardUrl("/admin")
                    .permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/justyou/login")
                    .permitAll();
        http.rememberMe().rememberMeParameter("remember");
        http.csrf().disable();
    }

    /**
     * 认证配置
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new CustomPasswordEncoder());
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}