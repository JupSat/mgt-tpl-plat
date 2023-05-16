package com.mgt.plat.service.impl;

import com.mgt.plat.entity.User;
import com.mgt.plat.mapper.UserMapper;
import com.mgt.plat.service.UserService;
import com.mgt.plat.utils.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

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
    public ResultBean<T> registerUser(HashMap<String, String> params, HttpSession session) {
        String username = params.get("username").trim();
        String password = params.get("password").trim();
        String email = params.get("email").trim();
        String validCod = params.get("validCod").trim();

        int code;

        if (validCod.isEmpty()) {
            return ResultBean.error("验证码不能为空！");
        }

        String emailCode = (String) session.getAttribute("emailCode");
        if (!validCod.equals(emailCode)) {
            return ResultBean.error("验证码过期，请重新获取！");
        }

        try {
            if (ObjectUtils.isEmpty(username)) {
                return ResultBean.error("用户名不能为空！");
            }

            User existedUser = this.findByUserName(username);
            if (existedUser != null) {
                return ResultBean.error("用户名已存在！");
            }

            User user = new User();
            user.setUsername(username).setPassword(AES256Util.encryptCBC(password)).setEmail(email);
            code = userMapper.insertUser(user);
            System.out.println(user);

            if (code >= 1) {
                return ResultBean.success("注册成功");
            } else {
                return ResultBean.error("系统异常！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error("注册失败: " + e.getMessage());
        }
    }

    @Override
    public ResultBean<T> sendAuthCodeEmail(String email, HttpSession session) {
        EmailBean emailBean = new EmailBean();
        if (email.isEmpty()) {
            return ResultBean.error("邮箱不能为空!");
        }
        int num = emailBean.sendAuthCodeToEmail(email, session);
        if (num == 1) {
            System.out.println("发送邮件完毕");
            return ResultBean.success("邮件发送成功，有效期为1分钟，请注意查收！" );
        } else {
            return ResultBean.error("邮件发送失败!");
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
    public ResultBean<T> updUserPwd(HashMap<String, String> params) {
        String email = params.get("email");
        String password = params.get("password");
        int key = userMapper.updUserPwd(email, password);
        try {
            System.out.println(key);
            if (key > 0) {
                return ResultBean.success("密码修改成功！");
            } else {
                return ResultBean.error("密码修改失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error("修改失败" + e.getMessage());
        }
    }

    @Override
    public ResultBean<String> login(HashMap<String, String> params, HttpSession session) {
        String username = params.get("username").trim();
        String password = params.get("password").trim();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return ResultBean.error("用户名或密码不能为空！");
        }

        String captchaVal = (String) session.getAttribute("captchaKey");
        String captcha = params.get("captcha").trim();
        if (StringUtils.isEmpty(captcha)) {
            return ResultBean.error("验证码不能为空！");
        }

        if (!captcha.equals(captchaVal)) {
            return ResultBean.error("验证码错误！");
        }

//        获取主体对象
//        Subject subject = SecurityUtils.getSubject();
//
//        获得token
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        subject.login(token);
        try {
            User user = this.findUser(username, AES256Util.encryptCBC(password));
            if (user != null) {
                String token = TokenUtil.createToken(username, password);
                session.setAttribute("loginUser", user);
                return ResultBean.success("登录成功！", token);
            } else {
                return ResultBean.error("用户名或密码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error("程序异常！");
        }
    }

    @Override
    public ResultBean<T> logout(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.removeAttribute("loginUser");
            }
            return ResultBean.success("退出登录！", null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error("退出失败" + e.getMessage());
        }
    }
}
