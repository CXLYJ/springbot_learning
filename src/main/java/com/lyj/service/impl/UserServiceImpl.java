package com.lyj.service.impl;

import com.lyj.dao.UserMapper;
import com.lyj.entity.MyEvent;
import com.lyj.entity.User;
import com.lyj.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by lyj on 2018/10/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return new User(1,"李依金","123456");
    }

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 发布事件
     * @return
     */
    @Override
    public User getMyEventUser() {
        User user = new User(1,"李依金","123456");
        //发布事件
        MyEvent event = new MyEvent(this,user);
        applicationContext.publishEvent(event);
        return user;
    }





    @Resource
    private UserMapper userMapper;

    @Override
    public User getByUserName(String username) {
        return userMapper.getByUserName(username);
    }

    @Override
    public Set<String> getRoles(String username) {
        return userMapper.getRoles(username);
    }

    @Override
    public Set<String> getPermissions(String username) {
        return userMapper.getPermissions(username);
    }
}
