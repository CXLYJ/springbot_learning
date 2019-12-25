package com.lyj.controller;

import com.lyj.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyj on 2018/10/19.
 */
@RestController
@RequestMapping("/json")
@Api(value = "系统自带返回json格式")
public class JsonController {

    @RequestMapping("/user")
    public User  getUser(){
        return new User(1,"李依金","123456");
    }

    @RequestMapping("/userList")
    public List<User> getUserList(){
        List<User> userList = new ArrayList<>();
        User user1 = new User(1,"李依金","123456");
        User user2 = new User(2,"上海","123456");
        userList.add(user1);
        userList.add(user2);
        return  userList;
    }

    @RequestMapping("/map")
    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        User user = new User(1,"李依金",null);
        map.put("作者信息",user);
        map.put("博客地址：","www.iclyj.cn");
        map.put("粉丝量：",null);
        return map;
    }

}
