package com.sensen.sensenshop.mbpg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sensen
 * @date 2021-01-01
 */
public class MyBatisPlusGenerator {

    private final static String AUTHOR = "sensen";

    private final static String FILE_PATH = "D:\\code_workspace\\IdeaProjects\\sensen-shop\\src\\main\\java";

    private final static String PACKAGE_PATH = "com.sensen.sensenshop";


    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/sensen_shop", "root", "wjh521521520")
                // 全局配置
                .globalConfig(builder -> {
                    builder.author(AUTHOR) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(FILE_PATH); // 指定输出目录

                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent(PACKAGE_PATH) // 设置父包名
                            .moduleName("mbpg")// 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\code_workspace\\IdeaProjects\\sensen-shop\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                // 策略配置
                .strategyConfig((scanner, builder) -> {
                    builder.addInclude(MyBatisPlusGenerator.getTables(scanner.apply("all")))
                            .addTablePrefix("cms_", "pms_", "oms", "sms_", "ums_")// 设置过滤表前缀
                            .controllerBuilder().enableRestStyle().enableHyphenStyle().build();
                    //配置service
//                    builder.serviceBuilder()
//                            .formatServiceFileName("%sService")
//                            .formatServiceImplFileName("%sServiceImp")
//                            .build();
                    //entity的策略配置
                    builder.entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .versionColumnName("version")
                            .logicDeleteColumnName("is_delete")
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .idType(IdType.ASSIGN_ID)
                            .formatFileName("%sDO")
                            .build();
                })
                .execute();
    }
}

