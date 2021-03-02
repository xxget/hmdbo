package com.zdh.hmdbo.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/11/11 22:23
 */
@Service
public class PlainService {

    @Scheduled(cron = "30 * * * * ?")
    public void cronScheduled(){
        System.out.println("我来了");
    }

}