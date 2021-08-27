package com.example.mybatisgenerator.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

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
        gc.setFileOverride(false);
        //主键策略
        gc.setIdType(IdType.AUTO);
        //定义生成的实体类中日期类型
        gc.setDateType(DateType.ONLY_DATE);
        //开启swagger2模式（Swagger和项目整合用于请求测试）
        gc.setSwagger2(true);

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
        pc.setModuleName("");
        pc.setParent("com.example");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
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

        //6.执行
        autoGenerator.execute();
    }
}
