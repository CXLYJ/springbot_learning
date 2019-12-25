package com.lyj.controller;

import com.lyj.annotation.UnInterception;
import com.lyj.jms.MsgProducer;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by lyj on 2018/10/30.
 */
@RestController
@RequestMapping("/activemq")
@Api(value = "ActiveMq测试")
public class ActiveMqController {

    private static final Logger logger = LoggerFactory.getLogger(ActiveMqController.class);

    @Resource
    private MsgProducer producer;

    @Resource
    private Destination queue;

    @Resource
    private Destination topic;

    /**
     * 点对点消息（pub-sub-domain: false）
     * @return
     */
    @GetMapping("/send/queue")
    @UnInterception
    public String sendQueueMessage() {
        logger.info("===开始发送点对点消息===");
        producer.sendMessage(queue, "Queue: hello activemq!");
        return "success";
    }

    /**
     * 开始发送订阅消息（pub-sub-domain: true）
     * @return
     */
    @GetMapping("/send/topic")
    @UnInterception
    public String sendTopicMessage() {
        logger.info("===开始发送订阅消息===");
        producer.sendMessage(topic, "Queue: hello activemq!");
        return "success";
    }

}
