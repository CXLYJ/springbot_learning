package com.lyj.jms;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by lyj on 2018/10/30.
 * 消息发送者
 */
@Service
public class MsgProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, String msg){
        jmsMessagingTemplate.convertAndSend(destination, msg);
    }

}
