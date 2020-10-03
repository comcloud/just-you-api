package com.cloud.api.config.security;

import com.cloud.api.util.MD5Util;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/3 10:00
 */
@Configuration
public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return MD5Util.encode((String) charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(MD5Util.encode((String) charSequence));
    }
}
