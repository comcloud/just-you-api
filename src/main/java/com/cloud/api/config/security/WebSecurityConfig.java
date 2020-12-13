package com.cloud.api.config.security;

import com.cloud.api.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * @author HP
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    private UserDetailsService userDetailsService = new UserDetailsServiceImpl();

    private static final String[] AUTH_WHITELIST = {

            // -- swagger ui
            "/swagger-ui.html",
            "/doc.html",
            "/document.html",
            "/swagger-ui/*",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/webjars/**"
    };

    /**
     * 请求配置
     * 这里拦截哪怕是允许所有人访问，但是依旧是需要走spring security的认证路线的
     * @param http 请求http
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/websocket").permitAll()
                .antMatchers("/message/**").permitAll()
                .antMatchers("/dynamic/**").permitAll()
                .antMatchers("/publish/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/taskRelease/**").permitAll()
                .antMatchers("/taskSearch/**").permitAll()
                //接口文档，暂时可以访问
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/static/**").permitAll()
                .antMatchers("/x-admin/js/**","/x-admin/css/**","/x-admin/images/*","/x-admin/fonts/**","/x-admin/**/*.png","/x-admin/**/*.jpg").permitAll()
                //图床接口
                .antMatchers("/upload/**").permitAll()
                //访问资源路径
                .antMatchers("/upload-image/**").permitAll()
                //官方访问
                .antMatchers("/","/index","/list","/about","/about2").permitAll()
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
                    .logoutSuccessUrl("/toLogin")
                    .permitAll();
        http.rememberMe().rememberMeParameter("remember");
        http.csrf().disable();
        //解决Refused to display '' in a frame because it set 'X-Frame-Options' to 'deny'问题
        http.headers().frameOptions().disable();
    }

    /**
     * 认证配置，也就是存储着如何进行认证，可以选择在内存中或者数据库认证
     * @param auth 认证建造器
     * @throws Exception 异常
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new CustomPasswordEncoder());
    }

    /**
     * 这个方法主要用来不拦截样式等静态文件，这个不拦截实际上是一种忽视，也就是不走spring security的认证路线而是直接放行
     * @param web web安全
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/x-admin/js/**","/x-admin/css/**",
                    "/x-admin/images/**","/x-admin/fonts/**","/x-admin/lib/**"
                ,"/official-website/**")
                .antMatchers("/taskHall/**")
                .antMatchers("/websocket/**");
    }
}