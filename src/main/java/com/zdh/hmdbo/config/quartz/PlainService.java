package com.zdh.hmdbo.config.quartz;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zdh.hmdbo.config.identity.GitIdInfo;
import com.zdh.hmdbo.fthfldtlinfo.controller.FthfldtlInfoController;
import com.zdh.hmdbo.fthfldtlinfo.entity.FthfldtlInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS",timezone="GMT+8")
    private Date initTime;

    @Autowired
    private FthfldtlInfoController fthfldtlInfoController;

    //@Scheduled(cron = "30 * * * * ?")
    //@Scheduled(fixedDelay = 3000)每隔3000毫秒执行一次，必须是上次调度成功后3000毫秒；
    @Scheduled(fixedRate = 5000)//每个3000毫秒执行一次，无论上次是否会执行成功，下次都会执行
    public void cronScheduled(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//设置日期格式
        log.info("[ "+ initTime + " ]");
        System.out.println("定时任务： " + df.format(new Date()) + "我来了。。。[ "+ gitIdInfo.genSnowFlakeId() + " ]");

        FthfldtlInfo fthfldtlInfo = new FthfldtlInfo();
        fthfldtlInfo.setColltime(new Date());
        log.info("11111111111111" + fthfldtlInfo.getColltime().toString());
        fthfldtlInfo.setPorttype("GPRS无线网络");
        fthfldtlInfo.setPortid("1");
        fthfldtlInfo.setDevaddr(0);
        fthfldtlInfo.setDensity((float) 0);
        fthfldtlInfo.setTempretu((float) 0);
        fthfldtlInfo.setPressure((float) 0);
        fthfldtlInfo.setDiffpres((float) 0);
        fthfldtlInfo.setFlow((float) 0);
        fthfldtlInfo.setSumflow((float) 0);
        fthfldtlInfo.setUserid("Test");
        fthfldtlInfo.setStatus("错误");
        fthfldtlInfo.setRetrycnt(1);
        fthfldtlInfo.setPrest((float) 0);
        fthfldtlInfo.setDiffpt((float) 0);
        fthfldtlInfo.setResetinfo(0);
        fthfldtlInfo.setWarninfo(0);
        fthfldtlInfo.setTStact(0);
        List<FthfldtlInfo> fthfldtlInfoList = (List<FthfldtlInfo>) fthfldtlInfoController.save(fthfldtlInfo);
        log.info(fthfldtlInfoList);
    }
}