package com.mgt.plat.config.jwt;

import com.mgt.plat.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * package name：com.mgt.plat.config.jwt
 * description：
 * user：JupSat
 * modification time：2023-01-28 21:21
 * modified content：
 **/
@Component
@Slf4j
public class TokenHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token != null) {
            boolean result = TokenUtil.verify(token);
            if (result) {
                log.info("经过拦截器");
                return true;
            }
        }
        log.info("认证失败");
        return false;
    }
}
