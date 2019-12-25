package com.lyj.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by lyj on 2018/11/4.
 * 异步定时任务
 */
@Component
public class AsyncTask {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    @Async
    public void task1(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("任务1耗时：" + (end-start));
    }

    @Async
    public void task2(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("任务2耗时：" + (end-start));
    }

    @Async
    public void task3(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("任务3耗时：" + (end-start));
    }

}
