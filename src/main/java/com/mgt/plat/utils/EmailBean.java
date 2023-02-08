package com.mgt.plat.utils;

import org.apache.commons.mail.HtmlEmail;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * package name：com.mgt.plat.utils
 * description：
 * user：JupSat
 * modification time：2023-01-02 10:32
 * modified content：
 **/
public class EmailBean {
    /**
     * 生成随机验证码
     * @param number 验证码位数
     * @return str
     */
     public String createRandomCode(int number) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

    /**
     * 发送验证码
     * @param email
     * @return
     */
    public int sendAuthCodeToEmail(String email, HttpSession session) {
        try {
            HtmlEmail mail = new HtmlEmail();
            /*发送邮件的服务器 126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com*/
            mail.setHostName("smtp.qq.com");
            /*不设置发送的消息有可能是乱码*/
            mail.setCharset("UTF-8");
            /*IMAP/SMTP服务的密码*/
            mail.setAuthentication("fyadxz@qq.com", "rxetybyldpvkdgid");
            /*发送邮件的邮箱和发件人*/
            mail.setFrom("fyadxz@qq.com", "若甫");
            /*使用安全链接*/
            mail.setSSLOnConnect(true);
            /*接收的邮箱*/
            mail.addTo(email);
            /*验证码*/
            String code = this.createRandomCode(6);
            /*存储验证码（暂时存于session）*/
            session.setAttribute("emailCode", code);
            /*设置邮件的主题*/
            mail.setSubject("注册验证码");
            /*设置邮件的内容*/
            mail.setMsg("尊敬的用户:你好! 注册验证码为:" + code + "(有效期为一分钟)");
            mail.send();//发送
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
}
