package com.lyj.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lyj on 2018/10/24.
 * aop切面测试
 */
@RestController
@RequestMapping("/aop")
@Api(value = "aop切面测试")
public class AopController {

    @GetMapping("/{name}")
    public String testAop(@PathVariable String name){
        return "hello " + name;
    }

}
