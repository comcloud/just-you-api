package com.cloud.api.config.security;

import com.cloud.api.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author HP
 */
@Configuration
@EnableWebSecurity
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
        //这里使用一种简单的方式
        //有一种对应方式，登录的
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                //loginPage的参数是要跳转的地址，这个地址是直接请求接口中的value
                //usernameParameter用来对应前端登录页面的用户名的name属性值，默认值是username，这里使用这个可以进行更改，passwordParameter同理
                //loginProcessingUrl用来定制跳往的页面，比如前端登录的form表单的action中写toLogin,这里就要写toLogin
                //logoutSuccessUrl指定登出之后跳往的页面
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login")
                    .permitAll()
                .and()
                .logout().logoutSuccessUrl("/login")
                .permitAll();
        //开启记住我功能，这个实际上是保存用户信息到cookie中，后面的remberMeParameter中的参数对应着前端选择框的name值
        http.rememberMe().rememberMeParameter("remember");
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