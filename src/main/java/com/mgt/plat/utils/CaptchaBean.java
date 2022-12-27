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
    private String captcha;
    private String captchaImgStr;

    public String createImage(String resultCode) throws IOException {
        final int WIDTH = 135;
        final int HEIGHT = 35;
        final int COUNT = 200; // 定义干扰线数量
        final int LINE_WIDTH = 2; //干扰线的长度=1.414*lineWidth

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);  // 在内存中创建图象
        Graphics2D graphics = (Graphics2D) image.getGraphics(); // 获取图形上下文

        graphics.setColor(Color.WHITE); // 设定背景颜色
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.drawRect(0, 0, WIDTH - 1, HEIGHT - 1); // 设定边框颜色

        Random random = new Random();

        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到
        for (int i = 0; i < COUNT; i++) {
            Random randomColor = new Random();
            int r = 150 + randomColor.nextInt(50);
            int g = 150 + randomColor.nextInt(50);
            int b = 150 + randomColor.nextInt(50);
            graphics.setColor(new Color(r, g, b));

            int x = random.nextInt(WIDTH - LINE_WIDTH - 1) + 1;  // 保证画在边框之内
            int y = random.nextInt(HEIGHT - LINE_WIDTH - 1) + 1;
            int xl = random.nextInt(LINE_WIDTH);
            int yl = random.nextInt(LINE_WIDTH);

            graphics.drawLine(x, y, x + xl, y + yl);
        }
        // 取随机产生的认证码
        for (int i = 0; i < resultCode.length(); i++) {
            graphics.setColor(getRandColor(110, 133));  // 设置字体颜色
            graphics.setFont(new Font("Times New Roman", Font.BOLD, 24)); // 设置字体样式
            graphics.drawString(String.valueOf(resultCode.charAt(i)), (22 * i) + 2, 26); // 设置字符，字符间距，上边距
        }

        graphics.dispose();

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", byteStream);
        byte[] bytes = byteStream.toByteArray();
        String base64 = Base64.getEncoder().encodeToString(bytes).trim();
        base64 = base64.replaceAll("\n", "").replaceAll("\r", ""); //删除 \r\n

        String imgStr = "data:image/jpg;base64," + base64;
        setCaptchaImgStr(imgStr);
        return imgStr;
    }

    public String randomString(String baseString, int length) {
        if (baseString == null || baseString.equals("")) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder(length);
            if (length < 1) {
                length = 1;
            }
            int baseLength = baseString.length();
            for (int i = 0; i < length; ++i) {
                int number = ThreadLocalRandom.current().nextInt(baseLength);
                sb.append(baseString.charAt(number));
            }
            setCaptcha(sb.toString());
            return sb.toString();
        }
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
}
