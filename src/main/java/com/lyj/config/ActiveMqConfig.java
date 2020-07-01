package com.lyj.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * Created by lyj on 2018/10/30.
 *
 * activemq的配置
 */
@Configuration
public class ActiveMqConfig {

    /**
     * 发布/订阅模式队列名称
     */
    public static final String TOPIC_NAME = "activemq.topic";
    /**
     * 点对点模式队列名称
     */
    public static final String QUEUE_NAME = "activemq.queue";

    @Bean
    public ActiveMQTopic topic() {
        return new ActiveMQTopic(TOPIC_NAME);
    }

    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue(QUEUE_NAME);
    }

    /**
     * JmsListener注解默认只接收queue消息,如果要接收topic消息,需要设置containerFactory
     */
    @Bean
    public JmsListenerContainerFactory topicListenerContainer(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        // 相当于在application.yml中配置：spring.jms.pub-sub-domain=true
        factory.setPubSubDomain(true);
        return factory;
    }

}
