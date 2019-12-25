package com.lyj.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lyj on 2018/11/4.
 * 定时任务
 */
@Component
public class QuartzTask {

    private static final Logger logger = LoggerFactory.getLogger(QuartzTask.class);

    @Scheduled(cron = "*/10 * * * * * ")
    public void task(){
        logger.info("每十秒执行一次.......");
    }

    @Scheduled(fixedRate = 20000)
    public void task1(){
        logger.info("每二十秒执行一次.......");
    }

    /**
     * 睡四秒再执行
     */
//    @Scheduled(fixedDelay = 2000)
//    public void time(){
//        try {
//            Thread.sleep(4000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        logger.info("当前时间 ：" + new Date());
//    }

}
