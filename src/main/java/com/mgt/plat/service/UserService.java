package com.mgt.plat.service;

import com.mgt.plat.entity.User;

/**
 * package name：com.mgt.plat.service.user
 * description：
 * user：JupSat
 * modification time：2022-12-17 12:45
 * modified content：
 **/
public interface UserService {
    Integer register(User user);

    User findByUserName(String username);

    User findUser(String username, String password);

    int updUserPwd(String email, String password);
}
