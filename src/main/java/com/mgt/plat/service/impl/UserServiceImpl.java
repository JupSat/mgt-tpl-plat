package com.mgt.plat.service.impl;

import com.mgt.plat.entity.User;
import com.mgt.plat.mapper.UserMapper;
import com.mgt.plat.service.UserService;
import com.mgt.plat.utils.CodeBean;
import com.mgt.plat.utils.EmailBean;
import com.mgt.plat.utils.ResultBean;
import com.mgt.plat.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
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
    public ResultBean registerUser(HashMap<String, String> params, HttpSession session) {
        String username = params.get("username").trim();
        String password = params.get("password").trim();
        String email = params.get("email").trim();
        String validCod = params.get("validCod").trim();

        int code;
        CodeBean codeBean = new CodeBean();

        if (validCod.isEmpty()) {
           return ResultBean.ok("验证码不能为空！");
        }

        String emailCode = (String) session.getAttribute("emailCode");
        if (!validCod.equals(emailCode)) {
            return ResultBean.error("验证码过期，请重新获取！");
        }

        try {
            if (!ObjectUtils.isEmpty(username)) {
                codeBean.setCode(0);
                codeBean.setMsg("用户名不能为空！");
                return ResultBean.error("用户名不能为空！", codeBean);
            }

            User existedUser = this.findByUserName(username);
            if (existedUser != null) {
                codeBean.setCode(3);
                codeBean.setMsg("用户名已存在");
                return ResultBean.error("用户名已存在！", codeBean);
            }

            User user = new User();
            user.setPassword(password).setEmail(email);
            code = userMapper.insertUser(user);
            System.out.println(user);

            if(code >= 1){
                codeBean.setCode(1);
                codeBean.setMsg("注册成功");
                return ResultBean.ok("注册成功", codeBean);
            } else {
                codeBean.setCode(4);
                codeBean.setMsg("系统异常");
                return ResultBean.error("系统异常！", codeBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error("注册失败", e.getMessage());
        }
    }

    @Override
    public ResultBean sendAuthCodeEmail(String email, HttpSession session) {
        EmailBean emailBean = new EmailBean();
        if (email.isEmpty()) {
            return ResultBean.error("邮箱不能为空!");
        }
        int num = emailBean.sendAuthCodeToEmail(email, session);
        if (num == 1) {
            System.out.println("发送邮件完毕");
            return ResultBean.ok("邮件发送成功，有效期为1分钟，请注意查收！", null);
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
    public ResultBean updUserPwd(HashMap<String, String> params) {
        String email = params.get("email");
        String password = params.get("password");
        int key = userMapper.updUserPwd(email, password);
        try {
            System.out.println(key);
            if (key > 0) {
                return ResultBean.ok("密码修改成功！");
            } else {
                return ResultBean.ok("密码修改失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error("修改失败",e.getMessage());
        }
    }

    @Override
    public ResultBean login(HashMap<String, String> params, HttpSession session) {
        String username = params.get("username").trim();
        String password = params.get("password").trim();

        CodeBean codeBean = new CodeBean();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) ){
            codeBean.setMsg("用户名或密码不能为空！");
            return ResultBean.ok(codeBean.getMsg(), codeBean);
        }

        String captchaVal = (String) session.getAttribute("captchaKey");
        String captcha = params.get("captcha").trim();
        if(StringUtils.isEmpty(captcha)){
            codeBean.setMsg("验证码不能为空！");
            return ResultBean.ok(codeBean.getMsg(), codeBean);
        }

        if (!captcha.equals(captchaVal)) {
            codeBean.setCode(3);
            codeBean.setMsg("验证码错误！");
            return ResultBean.ok("验证码错误！", codeBean);
        }

        //获取主体对象
//        Subject subject = SecurityUtils.getSubject();

        // 获得token
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        subject.login(token);

        try {
            User user = this.findUser(username, password);
            if (user != null) {
                codeBean.setCode(1);
                String token = TokenUtil.createToken(username,password);
                codeBean.setToken(token);
                codeBean.setMsg("登录成功！");
                session.setAttribute("loginUser", user);
            } else {
                codeBean.setCode(2);
                codeBean.setMsg("用户名或密码错误！");
            }
            return ResultBean.ok(codeBean.getMsg(), codeBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error("程序异常！");
        }
    }

    @Override
    public ResultBean logout(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.removeAttribute("loginUser");
            }
            CodeBean codeBean = new CodeBean();
            codeBean.setCode(1);
            codeBean.setMsg("退出成功！");
            return ResultBean.ok("退出登录！", codeBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error("退出失败",e.getMessage());
        }
    }
}
