package com.lyj.service;

import com.lyj.entity.BlogUser;

/**
 * Created by lyj on 2018/10/25.
 */
public interface BlogUserService {

    BlogUser getBlogUserByName(String username);

    BlogUser getBlogUserById(Long id);

    BlogUser getBlogUser(Long id, String userName);

    BlogUser getBlogUserByIds(Long id);

    BlogUser getBlogUser(Long id);

    void insertUser(BlogUser blogUser);

    void insertUser2(BlogUser blogUser) throws Exception;

    void insertUser3(BlogUser blogUser);

    void insertUser4(BlogUser blogUser) throws Exception;

    void insertUser5(BlogUser blogUser);

}
