package com.example.mybatisgenerator.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author qzz
 */
public class CodeGenerateUtils {

    /**
     * 运行main方法进行代码生成
     * @param args
     */
    public static void main(String[] args) {
        //1.创建代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //2.全局配置
        GlobalConfig gc = new GlobalConfig();
        //String projectPath = System.getProperty("user.dir");
        //建议直接使用项目绝对路径，以防相对路径找不到出错
        gc.setOutputDir("D:\\generator" + "/src/main/java");
        //作者
        gc.setAuthor("admin");
        //生成后是否打开资源管理员
        gc.setOpen(false);
        //重新生成时文件是否覆盖
        gc.setFileOverride(true);
        //主键策略
        gc.setIdType(IdType.AUTO);
        //定义生成的实体类中日期类型
        gc.setDateType(DateType.ONLY_DATE);
        //开启swagger2模式（Swagger和项目整合用于请求测试）
        gc.setSwagger2(true);

        //自定义文件命名 注意 %s 会自动填充表实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");

        autoGenerator.setGlobalConfig(gc);

        //3.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/db_test?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);

        autoGenerator.setDataSource(dsc);

        //4.包配置
        PackageConfig pc = new PackageConfig();
        //模块名
        pc.setParent("com.example");
        pc.setModuleName("mybatisgenerator");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");

        autoGenerator.setPackageInfo(pc);

        //5.策略配置
        StrategyConfig strategy = new StrategyConfig();
        //填写表名，帮助生成实体类等mapper相应代码
        strategy.setInclude("test_user");
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //生成实体时去掉表前缀
        strategy.setTablePrefix(pc.getModuleName()+"_");
        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //lombok 模型   @Accessors(chain = true) setter链式操作
        strategy.setEntityLombokModel(true);
        //restful api 风格控制器
        strategy.setRestControllerStyle(true);
        //url 中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);

        autoGenerator.setStrategy(strategy);

        //6.配置自定义模板
        //设置模板引擎    注意！如果您选择了非默认引擎，需要在 AutoGenerator 中 设置模板引擎
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        // 配置自定义输出模板
        //指定自定义模板路径， 位置：/resources/templates/entity.java.ftl(或者是.vm)
        // 注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("/templates/controller.java");
        templateConfig.setService("/templates/service.java");
        templateConfig.setServiceImpl("/templates/serviceImpl.java");
        templateConfig.setMapper("/templates/mapper.java");
        templateConfig.setEntity("/templates/entity.java");
        templateConfig.setXml("/templates/mapper.xml");
        autoGenerator.setTemplate(templateConfig);

        //6.执行
        autoGenerator.execute();
    }
}
