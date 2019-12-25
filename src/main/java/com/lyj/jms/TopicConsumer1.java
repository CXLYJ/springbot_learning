package com.lyj.jms;

import com.lyj.config.ActiveMqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Created by lyj on 2018/10/30.
 * Topic消息消费者
 */
@Service
public class TopicConsumer1 {

    /**
     * 接收订阅消息
     * @JmsListener 注解中指定这个容器工厂即可消费 Topic 消息
     * 指定 containerFactory 属性为上面我们自己配置的 topicListenerContainer 即可
     * @param msg
     */
    @JmsListener(destination = ActiveMqConfig.TOPIC_NAME, containerFactory = "topicListenerContainer")
    public void receiveTopicMsg(String msg){
        System.out.println("收到的消息为 :" + msg);
    }

}
