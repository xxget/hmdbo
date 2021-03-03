package com.zdh.hmdbo.generator;

import com.zdh.hmdbo.config.generate.GenerateMybatisPlus;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
/**
 * @Author(开发者) Xi
 * @E-mail(邮箱) xxget@live.com
 * @Description(说明) //代码生成方法
 * @Date(日期) 11:33 2021/3/3
 * @Param(参数)
 * @return(返回)
 * @Version(版本) 1.0.0
**/
@Log4j2
@SpringBootTest
@TestPropertySource("classpath:generate.properties")
class GenerateApplicationTests {

    //数据库数据源url
    @Value("${datasource.url}")
    private String dataSourceurl;

    //数据库用户名
    @Value("${datasource.username}")
    private String dataSourcename;

    //数据库登录密码
    @Value("${datasource.password}")
    private String dataSourcepassword;

    //数据库驱动
    @Value("${datasource.driver-class-name}")
    private String dataSourcedriver;
    //模块名
    @Value("${module.name}")
    private String moduleName;

    //需要生成的表名，多张表用英文逗号隔开 #
    @Value("${datatables.name}")
    private String tables;
    //父包名
    @Value("${package.parent}")
    private String packageParent;

    @Value("${datatables.isNormalize}")
    private boolean isNormalize;


    @Test
    void generateMybatisPlusTest() {
        new GenerateMybatisPlus().generate(
                dataSourceurl,
                dataSourcename,
                dataSourcepassword,
                dataSourcedriver,
                tables,
                packageParent,
                isNormalize,
                moduleName);
        log.info("代码生成方法执行完成！");
    }
}