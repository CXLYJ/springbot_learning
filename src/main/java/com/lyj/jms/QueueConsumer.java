package com.lyj.jms;

import com.lyj.config.ActiveMqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Created by lyj on 2018/10/30.
 * 消息消费者
 */
@Service
public class QueueConsumer {

    @JmsListener(destination = ActiveMqConfig.QUEUE_NAME)
    public void receiveQueueMsg(String msg){
        System.out.println("收到的消息为：" + msg);
    }

}
