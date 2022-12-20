package com.mgt.plat.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * package name：com.mgt.plat.config
 * description：
 * user：JupSat
 * modification time：2022-12-18 15:03
 * modified content：
 **/
@Configuration
@MapperScan("com.mgt.plat.mapper")
public class MybatisPlusConfig {
}
