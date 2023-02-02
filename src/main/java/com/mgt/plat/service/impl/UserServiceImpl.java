package com.mgt.plat.service.impl;

import com.mgt.plat.entity.User;
import com.mgt.plat.mapper.UserMapper;
import com.mgt.plat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * package name：com.mgt.plat.service.impl
 * description：
 * user：JupSat
 * modification time：2022-12-17 15:01
 * modified content：
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer register(User user) {
        if (!ObjectUtils.isEmpty(this.findByUserName(user.getUsername()))) {
            return 3;
        }
        user.setPassword(user.getPassword());
        int insert = userMapper.insertUser(user);
        System.out.println(user);
        if (insert >= 0) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.queryUserByUsername(username);
    }

    @Override
    public User findUser(String username, String password) {
        return userMapper.queryUser(username, password);
    }

    @Override
    public int updUserPwd(String email, String password) {
        return userMapper.updUserPwd(email, password);
    }
}
