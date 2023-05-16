package com.mgt.plat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MgtTplPlatApplication {
    public static void main(String[] args) {
        Logger logger= LoggerFactory.getLogger(MgtTplPlatApplication.class);
        SpringApplication.run(MgtTplPlatApplication.class, args);
        System.out.println("-------------------------启动成功！！！-------------------------");
        logger.info("启动成功！");
    }
}
