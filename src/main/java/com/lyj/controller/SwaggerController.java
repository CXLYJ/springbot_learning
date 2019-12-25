package com.lyj.controller;

import com.lyj.entity.JsonResult;
import com.lyj.entity.User;
import com.lyj.entity.Users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lyj on 2018/10/23.
 */
@RestController
@RequestMapping("/swagger")
//@Api 注解用于类上，表示标识这个类是 Swagger 的资源
@Api(value = "swagger2接口文档")
public class SwaggerController {

    @GetMapping("/get/{id}")
    //@ApiOperation 注解用于方法，表示一个 HTTP 请求的操作
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    //@ApiParam 注解用于参数上，用来标明参数信息
    public JsonResult<Users> getUsersInfo(@PathVariable @ApiParam(value = "用户唯一标识") Long id){
        Users users = new Users(id,"李依金","123456");
        return new JsonResult<>(users);
    }

//    @PostMapping("/insert")
//    @ApiOperation(value = "添加用户信息")
//    public JsonResult  insertUser(@RequestBody @ApiParam(value = "用户信息") Users users){
//        return  new JsonResult<>();
//    }


//    @PostMapping("/insert")
//    @ApiOperation(value = "添加用户信息")
//    public JsonResult<Void> insertUsers(@RequestBody @ApiParam(value = "用户信息") Users users) {
//        // 处理添加逻辑
//        return new JsonResult<>();
//    }

}
