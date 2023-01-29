package com.mgt.plat.config.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * package name：com.mgt.plat.config
 * description：token拦截
 * user：JupSat
 * modification time：2023-01-28 21:16
 * modified content：
 **/
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private TokenHandler tokenHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        String login = "/user/login";
        String register = "/user/register";
        String getVerifyCode = "/captcha/getCaptcha";
        excludePath.add(login);
        excludePath.add(register);
        excludePath.add(getVerifyCode);
        registry.addInterceptor(tokenHandler).excludePathPatterns(excludePath);
    }
}
