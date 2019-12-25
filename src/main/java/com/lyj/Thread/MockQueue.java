package com.lyj.Thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by lyj on 2018/11/13.
 * 模拟消息队列
 */
@Component
@Slf4j
public class MockQueue {

    //下单消息
    private  String placeOrder;

    //订单完成消息
    private  String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    /**
     * 单线程
     * @return
     */
//    public void setPlaceOrder(String placeOrder) {
//        new Thread(()->{
//            log.info("接到下单请求" + placeOrder);
//            //模拟处理
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            this.completeOrder = placeOrder;
//            log.info("下单请求处理完毕" + placeOrder);
//        }).start();
//    }

    /**
     * 异步线程
     * @param placeOrder
     * @throws InterruptedException
     */
    @Async
    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        log.info("接到下单请求"+ placeOrder);
        //模拟处理
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //给completeOrder赋值
        this.completeOrder = placeOrder;
        log.info("下单请求处理完毕"+placeOrder);
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
