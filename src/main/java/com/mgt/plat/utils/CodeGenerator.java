package com.mgt.plat.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * package name：com.mgt.plat.utils
 * description：代码生成器
 * user：JupSat
 * modification time：2023-02-10 10:32
 * modified content：
 **/
public class CodeGenerator {
    public static void main(String[] args) {
        // 1.创建代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 2.datasource数据源配置
        DataSourceConfig dataSource = new DataSourceConfig();
        // 2.1 设置驱动名
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        // 2.2 设置url
        dataSource.setUrl("jdbc:mysql://localhost:3306/mgt_tpl?serverTimezone=UTC&useSSL=false");
        // 2.3 设置用户名
        dataSource.setUsername("root");
        // 2.4 设置密码
        dataSource.setPassword("123456");
        // 2.5 设置数据源
        autoGenerator.setDataSource(dataSource);

        // 3. 设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 3.1 默认输出D盘根下，设置到这一目录下  mgt-tpl-plat/src/main/java
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath+"\\src\\main\\java");
        // 3.2设置完之后是否打开资源管理器
        globalConfig.setOpen(false);
        // 3.2 设置作者
        globalConfig.setAuthor("JupSat");
        // 3.3 设置是否覆盖原始生成的文件
        globalConfig.setFileOverride(true);
        // 3.4 设置数据层接口名，%s为占位符  代表数据库中的表名或模块名
        globalConfig.setMapperName("%sMapper");
        // 3.5 设置数据层接口名（为了去掉Service接口的首字母I）
        globalConfig.setServiceName("%sService");
        // 3.6 定义生成的实体类中日期类型
        globalConfig.setDateType(DateType.ONLY_DATE);
        // 3.7 设置id生成策略
        globalConfig.setIdType(IdType.ASSIGN_ID);
        // 3.8 开启Swagger2模式
        globalConfig.setSwagger2(true);
        // 3.9 xml开启 BaseResultMap
        globalConfig.setBaseResultMap(true);

        autoGenerator.setGlobalConfig(globalConfig);

        // 4. 设置包名相关配置
        PackageConfig packageConfig  =new PackageConfig();
        // 4.1 设置生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
        packageConfig.setParent("com.mgt.plat");
        // 4.2 设置实体类包名
        packageConfig.setEntity("entity");
        // 4.3 设置数据层包名
        packageConfig.setMapper("mapper");
        // 4.4 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 模板路径： 模板引擎为velocity（如果模板引擎是 freemarker则用 "/templates/mapper.xml.ftl"）
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                 String moduleName = packageConfig.getModuleName() == null ? "" : packageConfig.getModuleName();
                return projectPath + "/src/main/resources/mapper/" + moduleName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT + "xml";
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        autoGenerator.setCfg(injectionConfig);

        // 4.4 设置数据层包名
        autoGenerator.setPackageInfo(packageConfig);

        // 5. 策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        // 5.1 设置当前参与生成的表名，参数为可变参数  生成指定表
        strategyConfig.setInclude("purchaser_info");
        // 5.2 设置数据库表的前缀名称，模块名=数据库表名_前缀名
        strategyConfig.setTablePrefix("");
        // 5.3 是否启用Rest风格
        strategyConfig.setRestControllerStyle(true);
        // 5.4 设置乐观锁字段名
        strategyConfig.setVersionFieldName("version");
        // 5.5 设置逻辑删除字段名
        strategyConfig.setLogicDeleteFieldName("deleted");
        // 5.6 设置是否启用Lombok
        strategyConfig.setEntityLombokModel(true);
        // 5.7 设置列名下划线转驼峰命名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 5.8 列名数据库下划线至实体类属性支持驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);

        autoGenerator.setStrategy(strategyConfig);

        // 6. 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 6.1 设置xml(使其不产生xml文件夹和文件)
        templateConfig.setXml(null);
        // 6.2 设置模板
        autoGenerator.setTemplate(templateConfig);

        // 7. 执行生成操作
        autoGenerator.execute();
    }
}
