package com.lyj.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lyj on 2018/10/19.
 */
@RestController
@Api(value = "日志打印测试")
public class LoggerController {

    private final static Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping("/logger")
    public String testLoggger(){
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "www.iclyj.cn";
        String str2 = "iclyj.cn";
        logger.info("======李依金个人博客：{}；李依金的博客：{}", str1, str2);

        return "success";
    }

}
