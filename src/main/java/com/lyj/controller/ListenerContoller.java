package com.lyj.controller;

import com.lyj.entity.User;
import com.lyj.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by lyj on 2018/10/28.
 */
@RestController
@RequestMapping("/listener")
@Api(value = "监听器")
public class ListenerContoller {

    @Resource
    private UserService userService;

    @GetMapping("/user")
    public User getUser(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        return (User)application.getAttribute("user");
    }

    /**
     * 获取当前在线人数，该方法有bug
     * @param request
     * @return
     */
    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request){
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    /**
     * 获取当前在线人数 该方法无bug
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/totals")
    public String getsTotalUser(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie;
        //把sessionId记录在浏览器中
        try {
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(),"utf-8"));
            cookie.setPath("/");
            //设置cookie有效期为2天，设置长一点
            cookie.setMaxAge( 48*60 * 60);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    @GetMapping("/request")
    public String getRequest(HttpServletRequest request){
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }

    /**
     * 自定义事件
     * @return
     */
    @GetMapping("/publish")
    public User getPublish(){
        return userService.getMyEventUser();
    }

}
