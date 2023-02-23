package com.mgt.plat.service;

import com.mgt.plat.entity.User;
import com.mgt.plat.utils.ResultBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * package name：com.mgt.plat.service.user
 * description：
 * user：JupSat
 * modification time：2022-12-17 12:45
 * modified content：
 **/
public interface UserService {
    User findByUserName(String username);

    User findUser(String username, String password);

    ResultBean updUserPwd(HashMap<String, String> params);

    ResultBean sendAuthCodeEmail(@RequestParam("email") String email, HttpSession session);

    ResultBean registerUser(HashMap<String, String> params, HttpSession session);

    ResultBean login(@RequestBody HashMap<String, String> params, HttpSession session);

    ResultBean logout(HttpServletRequest request);
}
