package com.cloud.api.config.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import static org.springframework.messaging.simp.SimpMessageType.MESSAGE;
import static org.springframework.messaging.simp.SimpMessageType.SUBSCRIBE;

/**
 * websocket的配置类
 * 使用websocket的话基本需要三个类
 * 自定义拦截器：连接websocket服务器之后要做的一些拦截处理
 * 自定义处理器：对消息的各种处理
 * 主类就是配置类，用来把所有其他的内容添加到配置之中
 * @author 成都犀牛
 * @date 2020年10月20日16:06:20
 */
@Configuration
public class CustomWebSocketConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages
                .nullDestMatcher().authenticated()
                .simpSubscribeDestMatchers("/websocket/{openid}/{toOpenid}").permitAll()
                .simpDestMatchers("/app/**").hasRole("USER")
                .simpSubscribeDestMatchers("/user/**", "/topic/friends/*").hasRole("USER")
                .simpTypeMatchers(MESSAGE, SUBSCRIBE).denyAll()
                .anyMessage().denyAll();

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").withSockJS();
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}