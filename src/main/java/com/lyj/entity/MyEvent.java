package com.lyj.entity;

import org.springframework.context.ApplicationEvent;

/**
 * Created by lyj on 2018/10/28.
 * 自定义事件
 */
public class MyEvent extends ApplicationEvent {

    private User user;

    public MyEvent(Object source,User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
