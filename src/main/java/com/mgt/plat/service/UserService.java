package com.mgt.plat.service;

import com.mgt.plat.entity.User;
import com.mgt.plat.utils.ResultBean;

/**
 * package_name：com.mgt.plat.service.user
 * description：
 * user：JupSat
 * modification time：2022-12-17 12:45
 * modified content：
 **/
public interface UserService {
    ResultBean register(User user);
    User findByUserName(String username);
}
