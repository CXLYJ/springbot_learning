package com.lyj.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lyj on 2018/10/19.
 */
@RestController
@RequestMapping("/start")
@Api(value = "首页测试")
public class IndexController {

    @RequestMapping("/springboot")
    public String startSpringBoot() {
        return "Welcome to the world of Spring Boot!";
    }
}
