package com.lyj.JavaMailSender;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.StringWriter;

/**
 * Created by lyj on 2018/11/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaMailSenderTest {

//    @Autowired
//    private JavaMailSender mailSender;
//    @Autowired
//    private VelocityEngine velocityEngine;
//
//    @Test
//    public void sendTemplateMail() throws Exception {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.setFrom("1421805850@qq.com");//邮箱写自己可以测试用的
//        helper.setTo("1421805850@qq.com");//邮箱写自己可以测试用的
//        helper.setSubject("主题：模板邮件");
//        VelocityContext context = new VelocityContext();
//        context.put("username", "didi");
//        StringWriter stringWriter = new StringWriter();
//        // 需要注意第1个参数要全路径，否则会抛异常
//        velocityEngine.mergeTemplate("/templates/template.html", "UTF-8", context, stringWriter);
//        helper.setText(stringWriter.toString(), true);
//        mailSender.send(mimeMessage);
//    }

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Test
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo("1421805850@qq.com"); //自己给自己发送邮件
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }


    @Test
    public void sendHtmlSimpleMail() throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo("1421805850@qq.com");
        helper.setSubject("HTML主题");
        helper.setText("<html><body><img src=\"cid:qq\" >"
                + "</br>"
                +"祝我们520快乐!"
                + "</body></html>",true);
        // 发送图片
        File file = ResourceUtils.getFile("classpath:static/img/qq.jpg");
        //addInline("qq", file)的qq与上面的<img src="cid:qq" >"的qq对应
        helper.addInline("qq", file);
        // 发送附件
//        file = ResourceUtils.getFile("classpath:static/file/a.txt");
//        helper.addAttachment("附件名称", file);
        mailSender.send(message);

    }

}
