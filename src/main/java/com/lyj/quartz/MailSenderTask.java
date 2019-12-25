package com.lyj.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by lyj on 2018/11/8.
 * 定时发送邮件
 */
@Component
public class MailSenderTask {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    private static final Logger logger = LoggerFactory.getLogger(QuartzTask.class);

    @Scheduled(cron = "*/2 * * * * * ")
    public void task() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo("1421805850@qq.com"); //自己给自己发送邮件
        message.setSubject("主题：时光离世");
        message.setText("时光离世");
        mailSender.send(message);
        logger.info("每2秒执行一次.......");
    }

}
