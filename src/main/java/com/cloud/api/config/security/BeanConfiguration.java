package com.cloud.api.config.security;

import com.cloud.api.config.security.CustomPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/3 17:37
 */
@Configuration
public class BeanConfiguration {

    /**
     * @return Return to the custom password encryptor.
     * The reason why it is extracted separately as a configuration class is because if you don’t do this,
     * you cannot achieve unified password encryption, which leads to login failures.
     * Different password encryption results in different passwords.
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new CustomPasswordEncoder();
    }
}
