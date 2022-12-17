package com.mgt.plat.controller;

import com.mgt.plat.entity.User;
import com.mgt.plat.service.UserService;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * package_name：com.mgt.plat.controller
 * description：
 * user：JupSat
 * modification time：2022-12-17 14:53
 * modified content：
 **/
@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public ResultBean register(@RequestBody HashMap<String,String> params) {
        String username = params.get("username").trim();
        String password = params.get("password").trim();

        try {
            return userService.register(new User().setUsername(username).setPassword(password));
        }catch (Exception e){
            e.printStackTrace();
            return ResultBean.error("注册失败",e.getMessage());
        }
    }
}
