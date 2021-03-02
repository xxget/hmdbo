package com.zdh.hmdbo.generator;

import com.zdh.hmdbo.config.GenerateMybatisPlus;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
@Log4j2
@SpringBootTest
@TestPropertySource("classpath:generate.properties")
class GenerateApplicationTests {

    @Value("${datasource.url}")
    private String dataSourceurl;

    @Value("${datasource.username}")
    private String dataSourcename;

    @Value("${datasource.password}")
    private String dataSourcepassword;

    @Value("${datasource.driver-class-name}")
    private String dataSourcedriver;

    @Value("${datatables.name}")
    private String tables;

    @Value("${package.parent}")
    private String packageParent;

    @Value("${datatables.isNormalize}")
    private boolean isNormalize;

    @Test
    void generateMybatisPlusTest() {
        log.info("------------dataSourceurl: " + dataSourceurl);
        log.info("------------dataSourcename: " + dataSourcename);
        log.info("------------dataSourcepassword: " + dataSourcepassword);
        log.info("------------dataSourcedriver: " + dataSourcedriver);
        log.info("------------tables: " + tables);
        log.info("------------packageParent: " + packageParent);
        log.info("------------isNormalize: " + isNormalize);

        new GenerateMybatisPlus().generate(
                dataSourceurl,
                dataSourcename,
                dataSourcepassword,
                dataSourcedriver,
                tables,
                packageParent,
                isNormalize);
    }
}