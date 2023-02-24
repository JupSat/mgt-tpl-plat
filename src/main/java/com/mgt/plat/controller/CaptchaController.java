package com.mgt.plat.controller;

import com.mgt.plat.service.CaptchaService;
import com.mgt.plat.service.PurchaseRecordService;
import com.mgt.plat.utils.CaptchaBean;
import com.mgt.plat.utils.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * package name：com.mgt.plat.controller
 * description：验证码生成获取与校验
 * user：JupSat
 * modification time：2022-12-26 20:08
 * modified content：
 **/
@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;

    /**
     * 获取验证码
     */
    @PostMapping("/getCaptcha")
    public ResultBean getCaptcha(HttpSession session) {
        return captchaService.getCaptcha(session);
    }
}
