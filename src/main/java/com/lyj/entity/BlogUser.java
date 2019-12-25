package com.lyj.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by lyj on 2018/10/25.
 */
//此注解可以省略get/set方法
@Data
public class BlogUser {

    private  Long id ;

    private String nickName;

    private String userName;

    private String password;

    private String email;

    private String type;

    private String avator;

    private Date createTime;

    private Date updateTime;
}
