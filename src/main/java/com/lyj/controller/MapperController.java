package com.lyj.controller;

import com.lyj.entity.BlogUser;
import com.lyj.service.BlogUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by lyj on 2018/10/25.
 */
@RestController
@RequestMapping(value = "/mapper")
@Api(value = "mybatis整合测试")
public class MapperController {

    @Resource
    private BlogUserService blogUserService;

    @RequestMapping("/getBlogUserByName/{username}")
    public BlogUser getBlogUserByName(@PathVariable String username){
        return blogUserService.getBlogUserByName(username);
    }

    @RequestMapping("/getBlogUserById/{id}")
    public BlogUser getBlogUserById(@PathVariable Long id){
        return blogUserService.getBlogUserById(id);
    }

    @RequestMapping("/getUser/{id}/{userName}")
    public BlogUser getBlogUser(@PathVariable Long id, @PathVariable String userName) {
        return blogUserService.getBlogUser(id, userName);
    }

    @RequestMapping("/getBlogUserByIds/{id}")
    public BlogUser getBlogUserByIds(@PathVariable Long id) {
        return blogUserService.getBlogUserByIds(id);
    }

    @RequestMapping("/getBlogUser/{id}")
    public BlogUser getBlogUser(@PathVariable Long id) {
        return blogUserService.getBlogUser(id);
    }

}
