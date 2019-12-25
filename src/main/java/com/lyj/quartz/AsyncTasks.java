package com.lyj.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by lyj on 2018/11/4.
 * 获取几个任务的响应结果
 */
//在类上加上注解
@Component
@Async //异步执行
public class AsyncTasks {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTasks.class);

    /**
     * 1）要把异步任务封装到类里面，不能直接写到Controller
     * 2）增加Future<String> 返回结果 AsyncResult<String>("task执行完成");  
     * 3）如果需要拿到结果 需要判断全部的 task.isDone()
     * @return
     */
    public Future<String> task4(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("任务4耗时：" + (end - start));
        return new AsyncResult<String>("任务4");
    }

    public Future<String> task5(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("任务5耗时：" + (end - start));
        return new AsyncResult<String>("任务5");
    }

    public Future<String> task6(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("任务6耗时：" + (end - start));
        return new AsyncResult<String>("任务6");
    }

}
