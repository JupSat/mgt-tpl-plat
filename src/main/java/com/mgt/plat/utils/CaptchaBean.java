package com.mgt.plat.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * package name：com.mgt.plat.utils
 * description：
 * user：JupSat
 * modification time：2022-12-26 19:58
 * modified content：
 **/

@Getter
@Setter
@ToString
 public class CaptchaBean {
    private String captcha; // 验证码
    private String captchaImgStr; // 验证码图片

    public CaptchaBean() throws IOException {
        String code = getRandomCode();
        createCaptchaImg(code);
    }

    public void createCaptchaImg(String resultCode) throws IOException {
        int width = 135;
        int height = 35;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  // 在内存中创建图象
        Graphics2D g = (Graphics2D) image.getGraphics(); // 获取图形上下文

        g.setColor(Color.WHITE); // 设定背景颜色
        g.fillRect(0, 0, width, height);
        g.drawRect(0, 0, width - 1, height - 1); // 设定边框颜色

        drawLines(g,width, height); // 绘制干扰线
        drawString(g, resultCode); // 绘制字符串（验证码）

        g.dispose();

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", byteStream);

        byte[] bytes = byteStream.toByteArray();
        String base64 = Base64.getEncoder().encodeToString(bytes).trim();
        base64 = base64.replaceAll("\n", "").replaceAll("\r", ""); //删除 \r\n

        String imgStr = "data:image/jpg;base64," + base64;
        setCaptchaImgStr(imgStr); // 存值以便于返回给前端
    }

    public String getRandomCode() {
        //  String randString  = "0123456789";
        String randStr  = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 验证码随机字符
        int captchaLen = 6;  // 验证码长度
        StringBuilder sb = new StringBuilder(captchaLen);

        int len = randStr.length();
        for (int i = 0; i < captchaLen; ++i) {
            int number = ThreadLocalRandom.current().nextInt(len);
            sb.append(randStr.charAt(number));
        }
        setCaptcha(sb.toString());
        return sb.toString();
    }

    /**
     * 获取颜色
     * @param fc:
     * @param bc:
     * @return Color
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 绘制字符串
     */
    private void drawString(Graphics g, String code) {
        for (int i = 0; i < code.length(); i++) {
            g.setColor(getRandColor(110, 133));  // 设置字体颜色
            g.setFont(new Font("Times New Roman", Font.BOLD, 24)); // 设置字体样式
            g.drawString(String.valueOf(code.charAt(i)), (22 * i) + 2, 26); // 设置字符，字符间距，上边距
        }

    }

    /**
     * 绘制干扰线
     */
    private void drawLines(Graphics graphics,int width, int height) {
        int line_width = 2; //干扰线的长度
        int count = 200; // 定义干扰线数量
        Random random  = new Random();

        for (int i = 0; i < count; i++) {
            int r = 150 + random.nextInt(50);
            int g = 150 + random.nextInt(50);
            int b = 150 + random.nextInt(50);
            graphics.setColor(new Color(r, g, b));

            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(line_width);
            int yl = random.nextInt(line_width);

            graphics.drawLine(x, y, x + xl, y + yl);
        }
    }
}
