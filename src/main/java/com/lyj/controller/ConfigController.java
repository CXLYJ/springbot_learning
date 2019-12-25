package com.lyj.controller;

import com.lyj.config.MicroServiceUrl;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lyj on 2018/10/19.
 */
@RestController
@RequestMapping("/test")
@Api(value = "获取生成和测两个不同的环境")
public class ConfigController {

    private final static Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Value("${url.orderUrl}")
    private String orderUrl;

    @Resource
    private MicroServiceUrl microServiceUrl;

    @RequestMapping("/config")
    public String testConfig(){
        logger.info("===获取的订单服务地址：{}",orderUrl);
        return  "success";
    }

    @RequestMapping("/urlConfig")
    public String testUrlConfig() {
        logger.info("=====获取的订单服务地址为：{}", orderUrl);
        // 使用配置类来获取
        logger.info("=====获取的订单服务地址为：{}", microServiceUrl.getOrderUrl());
        logger.info("=====获取的用户服务地址为：{}", microServiceUrl.getUserUrl());
        logger.info("=====获取的购物车服务地址为：{}", microServiceUrl.getShoppingUrl());
        return "success";
    }

}
