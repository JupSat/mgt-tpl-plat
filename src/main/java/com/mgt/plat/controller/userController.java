package com.mgt.plat.controller;

import com.mgt.plat.entity.User;
import com.mgt.plat.service.UserService;
import com.mgt.plat.utils.CodeBean;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * package name：com.mgt.plat.controller
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
    public ResultBean register(@RequestBody HashMap<String, String> params) {
        String username = params.get("username").trim();
        String password = params.get("password").trim();
        String email = params.get("email").trim();
        Integer code;
        CodeBean codeBean = new CodeBean();

        try {
            code = userService.register(new User().setUsername(username).setPassword(password).setEmail(email));
            if(code == 1){
                codeBean.setCode(1);
                codeBean.setMsg("注册成功");
                return ResultBean.ok("注册成功", codeBean);
            }else if(code == 2){
                codeBean.setCode(2);
                codeBean.setMsg("注册失败");
                return ResultBean.error("创建失败！", codeBean);
            } else if(code == 3){
                codeBean.setCode(3);
                codeBean.setMsg("用户名已存在");
                return ResultBean.error("用户名已存在！", codeBean);
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

    @PostMapping("/login")
    @ResponseBody
    public ResultBean login(@RequestBody HashMap<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");
        try {
            User user = userService.findUser(username, password);
            System.out.println(user);
            CodeBean codeBean = new CodeBean();
            if (user != null) {
                codeBean.setCode(1);
                codeBean.setMsg("登录成功！");
            } else {
                codeBean.setCode(0);
                codeBean.setMsg("登录失败！");
            }
            return ResultBean.ok(codeBean.getMsg(), codeBean);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("用户名或密码错误!");
            return ResultBean.error("用户名或密码错误！");
        }
    }

    @PostMapping("/logout")
    @ResponseBody
    public ResultBean logout() {
        try {
            return ResultBean.ok("退出登录！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error("退出失败",e.getMessage());
         }
     }

    @PostMapping("/resetPwd")
    @ResponseBody
    public ResultBean resetPwd(@RequestBody HashMap<String, String> params) {
        String email = params.get("email");
        String password = params.get("password");
        int key = userService.updUserPwd(email, password);
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
}
