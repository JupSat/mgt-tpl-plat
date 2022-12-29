package com.mgt.plat.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * package name：com.mgt.plat.config.shiro
 * description：
 * user：JupSat
 * modification time：2022-12-29 22:41
 * modified content：
 **/
public class UserRealm extends AuthorizingRealm {
    /**
     * 授权
     * @param principals:
     * @return null
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了=》授权doGetAuthorizationInfo");
        return null;
    }

    /**
     * 认证
     * @param token:
     * @return null
     * @throws AuthenticationException:
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=》认证doGetAuthorizationInfo");
        return null;
    }
}
