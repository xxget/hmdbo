package com.zdh.hmdbo.config.quartz;

import com.zdh.hmdbo.config.identity.GitIdInfo;
import com.zdh.hmdbo.fthfldtlinfo.controller.FthfldtlInfoController;
import com.zdh.hmdbo.fthfldtlinfo.entity.FthfldtlInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/11/11 22:23
 */
@Log4j2
@Service
public class PlainService {



    @Autowired
    private GitIdInfo gitIdInfo;

    @Autowired
    private FthfldtlInfoController fthfldtlInfoController;

    //@Scheduled(cron = "30 * * * * ?")
    //@Scheduled(fixedDelay = 3000)每隔3000毫秒执行一次，必须是上次调度成功后3000毫秒；
    @Scheduled(fixedRate = 5000)//每个3000毫秒执行一次，无论上次是否会执行成功，下次都会执行
    public void cronScheduled(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       // log.info(df.format(new Date()) + "我来了。。。[ "+ gitIdInfo.genSnowFlakeId() + " ]");
        System.out.println("定时任务： " + df.format(new Date()) + "我来了。。。[ "+ gitIdInfo.genSnowFlakeId() + " ]");

        FthfldtlInfo fthfldtlInfo = new FthfldtlInfo();
        List<FthfldtlInfo> fthfldtlInfoList = (List<FthfldtlInfo>) fthfldtlInfoController.list(fthfldtlInfo);
        log.info(fthfldtlInfoList);
    }
}