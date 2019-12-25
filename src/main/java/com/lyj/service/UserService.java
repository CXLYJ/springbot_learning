package com.lyj.service;

import com.lyj.entity.User;

import java.util.Set;

/**
 * Created by lyj on 2018/10/28.
 */
public interface UserService {

    User getUser();

    User getMyEventUser();

    User getByUserName(String username);

    Set<String> getRoles(String username);

    Set<String> getPermissions(String username);
}
