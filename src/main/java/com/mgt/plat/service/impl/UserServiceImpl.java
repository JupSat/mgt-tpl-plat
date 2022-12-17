package com.mgt.plat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mgt.plat.entity.User;
import com.mgt.plat.mapper.UserMapper;
import com.mgt.plat.service.UserService;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * package_name：com.mgt.plat.service.impl
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
    public ResultBean register(User user) {
        if(!ObjectUtils.isEmpty(this.findByUserName(user.getUsername()))){
            return ResultBean.warn("用户名已存在请重新输入");
        }
        user.setPassword(user.getPassword());
        int insert = userMapper.insert(user);
        System.out.println(user);
        if(insert >=0){
            return ResultBean.ok("注册成功username="+user.getUsername(),user);
        }else{
            return ResultBean.error("创建失败！");
        }
    }

    @Override
    public User findByUserName(String username) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        System.out.println(user);
        return user;
    }
}
