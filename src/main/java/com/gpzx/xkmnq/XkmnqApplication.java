package com.gpzx.xkmnq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.gpzx.xkmnq.domain"})
//定时任务
//@EnableScheduling
public class XkmnqApplication {

    public static void main(String[] args) {
        SpringApplication.run(XkmnqApplication.class, args);
    }

}
