package com.mgt.plat.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

 public class CaptchaBean {

    public String produceImage(String resultCode) throws IOException {
        final int WIDTH = 135;
        final int HEIGHT = 35;
        final int COUNT = 200; // 定义干扰线数量
        final int LINE_WIDTH = 2; //干扰线的长度=1.414*lineWidth

        final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);  // 在内存中创建图象

        final Graphics2D graphics = (Graphics2D) image.getGraphics(); // 获取图形上下文

        graphics.setColor(Color.WHITE); // 设定背景颜色
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        graphics.drawRect(0, 0, WIDTH - 1, HEIGHT - 1); // 设定边框颜色

        final Random random = new Random();

        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到
        for (int i = 0; i < COUNT; i++) {
            final Random randomColor = new Random();
            final int r = 150 + randomColor.nextInt(50);
            final int g = 150 + randomColor.nextInt(50);
            final int b = 150 + randomColor.nextInt(50);
            graphics.setColor(new Color(r, g, b));

            final int x = random.nextInt(WIDTH - LINE_WIDTH - 1) + 1;  // 保证画在边框之内
            final int y = random.nextInt(HEIGHT - LINE_WIDTH - 1) + 1;
            final int xl = random.nextInt(LINE_WIDTH);
            final int yl = random.nextInt(LINE_WIDTH);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        // 取随机产生的认证码
        for (int i = 0; i < resultCode.length(); i++) {
            graphics.setColor(Color.BLACK);  // 设置字体颜色
            graphics.setFont(new Font("Times New Roman", Font.BOLD, 24)); // 设置字体样式
            graphics.drawString(String.valueOf(resultCode.charAt(i)), (22 * i) + 2, 26); // 设置字符，字符间距，上边距
        }
        graphics.dispose();

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", byteStream);
        byte[] bytes = byteStream.toByteArray();
        String base64 = Base64.getEncoder().encodeToString(bytes).trim();
        base64 = base64.replaceAll("\n", "").replaceAll("\r", ""); //删除 \r\n

        return "data:image/jpg;base64," + base64;
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

            return sb.toString();
        }
    }
}
