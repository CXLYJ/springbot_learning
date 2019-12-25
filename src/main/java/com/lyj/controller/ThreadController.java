package com.lyj.controller;

import com.lyj.Thread.DeferredResultHolder;
import com.lyj.Thread.MockQueue;
import com.lyj.annotation.UnInterception;
import com.lyj.util.RandomUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import sun.rmi.runtime.Log;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by lyj on 2018/11/13.
 * 线程测试
 */
@RestController
@Api(value = "线程测试")
@Slf4j
@RequestMapping("/thread")
public class ThreadController {

    /**
     * 单线程测试
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/order")
    public String order() throws InterruptedException {
        log.info("主线程开始");
        Thread.sleep(1000);
        log.info("主线程返回");
        return "success";
    }

    /**
     * 用Callable实现异步
     * @return
     * @throws InterruptedException
     */
    @UnInterception
    @RequestMapping("/orderAsync")
    public Callable orderAsync() throws InterruptedException {
        log.info("主线程开始");
        Callable result = new Callable() {
            @Override
            public Object call() throws Exception {
                log.info("副线程开始");
                Thread.sleep(1000);
                log.info("副线程返回");
                return "success";
            }
        };
        log.info("主线程返回");
        return result;
    }


    //注入消息队列列表
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @RequestMapping("/orderMockQueue")
    public DeferredResult orderQueue() throws InterruptedException {
        log.info("主线程开始");

        //随机生成八位数
        String orderNumber = RandomUtil.getRandom(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult result = new DeferredResult();
        deferredResultHolder.getMap().put(orderNumber,result);
        Thread.sleep(2000);
        log.info("主线程返回");

        return result;
    }

}
