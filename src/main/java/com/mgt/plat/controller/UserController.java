package com.mgt.plat.controller;

import com.mgt.plat.entity.User;
import com.mgt.plat.service.UserService;
import com.mgt.plat.utils.CodeBean;
import com.mgt.plat.utils.EmailBean;
import com.mgt.plat.utils.ResultBean;
import com.mgt.plat.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * package name：com.mgt.plat.controller
 * description：
 * user：JupSat
 * modification time：2022-12-17 14:53
 * modified content：
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResultBean register(@RequestBody HashMap<String, String> params, HttpSession session) {
        return userService.registerUser(params, session);
    }

    @PostMapping("/sendVerificationCodeToEmail")
    public ResultBean sendAuthCodeEmail(@RequestParam("email") String email, HttpSession session) {
        return userService.sendAuthCodeEmail(email, session);
    }

    @PostMapping("/login")
    public ResultBean login(@RequestBody HashMap<String, String> params, HttpSession session) {
        return userService.login(params, session);
    }

    @PostMapping("/logout")
    public ResultBean logout(HttpServletRequest request) {
        return userService.logout(request);
    }

    @PostMapping("/resetPwd")
    public ResultBean resetPwd(@RequestBody HashMap<String, String> params) {
        return userService.updUserPwd(params);
    }
}
