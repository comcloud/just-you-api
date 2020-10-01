package com.cloud.api.config.security;

import com.cloud.api.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author HP
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();

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
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/justyou/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginProcessingUrl("/justyou/login")
                    .successForwardUrl("/justyou/admin")
                    .permitAll()
                .and()
                .logout().logoutSuccessUrl("/justyou/login")
                .permitAll();
        //开启记住我功能，这个实际上是保存用户信息到cookie中，后面的remberMeParameter中的参数对应着前端选择框的name值
//        http.rememberMe().rememberMeParameter("remember");
        http.csrf().disable();//关闭csrf功能，登录失败的原因所在
    }

    /**
     * 认证配置
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.
                // <X> 使用内存中的 InMemoryUserDetailsManager
//                        inMemoryAuthentication()
                // <Y> 不使用 PasswordEncoder 密码编码器
//                .passwordEncoder(new BCryptPasswordEncoder())
                // <Z> 配置 admin 用户
//                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("ADMIN")
                // <Z> 配置 normal 用户
//                .and().withUser("normal").password(new BCryptPasswordEncoder().encode("normal")).roles("NORMAL");
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //防止拦截静态文件
        web.ignoring().antMatchers("/**");
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }

}