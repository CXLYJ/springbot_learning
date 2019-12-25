package com.lyj.controller;

import com.lyj.entity.JsonResult;
import com.lyj.entity.Result;
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
@RequestMapping("/jsonResult")
@Api(value = "自定义返回json格式")
public class JsonResultController {

    @RequestMapping("/user")
    public JsonResult getUser(){
        User user = new User(1,"李依金","123456");
        return new JsonResult(user);
    }

    @RequestMapping("/user2")
    public Result getUser2(){
        User user = new User(1,"李依金2","123456");
        return Result.ok().put("user",user);
    }

    @RequestMapping("/list")
    public JsonResult getUserList(){
        List<User> userList = new ArrayList<>();
        User user1 = new User(1,"李依金","123456");
        User user2 = new User(2,"上海","123456");
        userList.add(user1);
        userList.add(user2);
        return new JsonResult(userList,"获取用户列表成功");
    }

    @RequestMapping("/list2")
    public Result getUserList2(){
        List<User> userList = new ArrayList<>();
        User user1 = new User(1,"李依金2","123456");
        User user2 = new User(2,"上海2","123456");
        userList.add(user1);
        userList.add(user2);
        return Result.ok().put("userList",userList).put("user1",user1).put("user2",user2);
    }

    @RequestMapping("/map")
    public JsonResult getMap() {
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1, "李依金", null);
        map.put("作者信息", user);
        map.put("博客地址", "http://www.iclyj.cn");
        map.put("CSDN地址", null);
        map.put("粉丝数量", 4153);
        return new JsonResult(map);
    }

}
