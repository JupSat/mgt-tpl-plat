package com.mgt.plat.config;

 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
 import springfox.documentation.service.Contact;
 import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

 import java.util.ArrayList;

/**
 * package name：com.mgt.plat.config
 * description：
 * user：JupSat
 * modification time：2023-01-08 13:04
 * modified content：
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 配置docket 的bean实例
     * @return new Docket
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    /**
     * 配置swagger信息
     * @return new ApiInfo
     */
    private ApiInfo apiInfo() {

        Contact contact = new Contact("JupSat", "https://github.com/JupSat/mgt-tpl-plat", "xxx@163.com");      //作者信息

        return new ApiInfo("mgt-tpl-plat的API文档",  //标题
                "文档描述",          //描述
                "v1.0",           //api版本
                "https://github.com/JupSat/mgt-tpl-plat",
                contact,         //作者信息
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
}