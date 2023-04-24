package com.mgt.plat.service;

import com.mgt.plat.utils.CaptchaBean;
import com.mgt.plat.utils.Result;

import javax.servlet.http.HttpSession;

/**
 * package name：com.mgt.plat.service
 * description：
 * user：JupSat
 * modification time：2023-02-24 20:08
 * modified content：
 **/
public interface CaptchaService {
    Result<CaptchaBean> getCaptcha(HttpSession session);
}
