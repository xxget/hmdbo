package com.zdh.hmdbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// 开启任务调度
@EnableScheduling
@SpringBootApplication
public class GenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerateApplication.class, args);
		System.out.println("项目启动完成！");
	}

}
