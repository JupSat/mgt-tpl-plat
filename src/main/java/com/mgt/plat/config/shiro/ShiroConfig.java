package com.mgt.plat.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * package name：com.mgt.plat.config
 * description：
 * user：JupSat
 * modification time：2022-12-29 22:28
 * modified content：
 **/
@Configuration
public class ShiroConfig {
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();//关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean =new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        /*
        添加shiro的内置过滤器=>
         anon: 无需认证就可以访问
         authc: 必须认证了才能让问
         user: 必须拥有 记住我 功能才能用
         perms: 拥有对某个资源的权限才能访问;
         role:拥有某个角色权限才能访问
        */

        Map<String,String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/user/add","authc");
//        filterMap.put("/user/update","authc");
        filterMap.put("/user/login","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        return bean;
    }
}
