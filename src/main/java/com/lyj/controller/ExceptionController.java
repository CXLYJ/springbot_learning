package com.lyj.controller;

import com.lyj.entity.JsonResults;
import com.lyj.exception.BusinessErrorException;
import com.lyj.exception.BusinessMsgEnum;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lyj on 2018/10/24.
 */
@RestController
@RequestMapping("/exception")
@Api(value = "异常测试")
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @PostMapping("/test")
    public JsonResults test(@RequestParam("name") String name,
                           @RequestParam("pass") String pass) {
        logger.info("name：{}", name);
        logger.info("pass：{}", pass);
        return new JsonResults();
    }

    @GetMapping("/null/exception")
    public JsonResults testNullPointException() {
        String str = null;
        str.length();
        return new JsonResults();
    }

    @GetMapping("/business")
    public JsonResults testException(){
       try {
            int i = 1/0;
       }catch (Exception e){
            throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
       }
        return new JsonResults();
    }

}
