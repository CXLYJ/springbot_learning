package com.lyj.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lyj on 2018/10/23.
 */
@Controller
@RequestMapping("/thymeleaf")
@Api(value = "thymeleaf测试")
public class ThymeleafController {

    @RequestMapping("/404")
    public String test404() {
        return "index";
    }

    @RequestMapping("/500")
    public String test500() {
        int i = 1 / 0;
        return "index";
    }

}
