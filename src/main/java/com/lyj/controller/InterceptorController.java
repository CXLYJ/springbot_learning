package com.lyj.controller;

import com.lyj.annotation.UnInterception;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lyj on 2018/10/29.
 */
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/test")
    public String test() {
        return "hello";
    }

    //测试地址：http://localhost:81/interceptor/work
    @UnInterception
    @RequestMapping(value = "/work"/*,produces = "text/plain;charset=UTF-8"*/)
    public String work(){
        return "我没有被拦截";
    }

}
