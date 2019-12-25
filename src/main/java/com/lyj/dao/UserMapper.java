package com.lyj.dao;

import com.lyj.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * Created by lyj on 2018/10/31.
 */
public interface UserMapper {

    @Select("select * from t_user where username = #{username}")
    User getByUserName(String username);

    @Select("select r.rolename from t_user u,t_role r " +
            "where u.role_id = r.id and u.username = #{username}")
    Set<String> getRoles(String username);

    @Select("select p.permissionname from t_user u,t_role r,t_permission p " +
            "where u.role_id = r.id and p.role_id = r.id and u.username = #{username}")
    Set<String> getPermissions(String username);

}
