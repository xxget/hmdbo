package com.zdh.hmdbo.config.identity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author(开发者) Xi
 * @E-mail(邮箱) xxget@live.com
 * @Description(说明) //雪花算法ID输出
 * @Date(日期) 11:03 2021/2/24
 * @Param(参数)
 * @return(返回)
 * @Version(版本) 1.0.0
**/
@RestController
@RequestMapping("/snowflake")
public class GitIdInfo {
    @Autowired
    private SnowFlakeFactory snowFlakeFactory;

    /*
     * 雪花算法ID输出
     * @E-mail(邮箱) xxget@live.com
     * @Description(说明) //TODO 雪花算法ID输出
     * @Date(日期) 11:27 2021/2/24
     * @Param(参数) []
     * @return(返回) 雪花算法生成主键java.lang.String
     * @Version(版本) 1.0.0
    **/
    @Bean
    public String genSnowFlakeId() {
        return snowFlakeFactory.nextId(BRStyle.CO);
    }

}