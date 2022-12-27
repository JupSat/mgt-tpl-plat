package com.mgt.plat.controller;

import com.mgt.plat.utils.CaptchaBean;
import com.mgt.plat.utils.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * package name：com.mgt.plat.controller
 * description：验证码生成获取与校验
 * user：JupSat
 * modification time：2022-12-26 20:08
 * modified content：
 **/
@Controller
@RequestMapping("/captcha")
public class CaptchaController {
    private final static Logger logger = LoggerFactory.getLogger(CaptchaController.class);

    /**
     * 获取验证码
     */
    @PostMapping("/getCaptcha")
    @ResponseBody
    public ResultBean getCaptcha() {
        try {
            CaptchaBean captchaBean = new CaptchaBean();
            String BASE_NUMBER = "0123456789";
            String captcha = captchaBean.randomString(BASE_NUMBER, 6);
            captchaBean.createImage(captcha);
            return ResultBean.ok("获取验证码成功", captchaBean);
        } catch (Exception e) {
            logger.error("获取验证码失败", e);
            return  ResultBean.ok("获取验证码失败");
        }
    }
}
