package com.mgt.plat.service.impl;

import com.mgt.plat.controller.CaptchaController;
import com.mgt.plat.service.CaptchaService;
import com.mgt.plat.utils.CaptchaBean;
import com.mgt.plat.utils.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


/**
 * package name：com.mgt.plat.service.impl
 * description：
 * user：JupSat
 * modification time：2023-02-24 20:09
 * modified content：
 **/
@Service
public class CaptchaServiceImpl implements CaptchaService {
    private final static Logger logger = LoggerFactory.getLogger(CaptchaController.class);

    @Override
    public ResultBean<CaptchaBean> getCaptcha(HttpSession session) {
        try {
            CaptchaBean captchaBean = new CaptchaBean();
            session.setAttribute("captchaKey", captchaBean.getCaptcha());
            return ResultBean.success(captchaBean);
        } catch (Exception e) {
            logger.error("获取验证码失败", e);
            return ResultBean.error("获取验证码失败");
        }
    }
}
