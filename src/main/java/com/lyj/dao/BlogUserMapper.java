package com.lyj.dao;

import com.lyj.entity.BlogUser;
import org.apache.ibatis.annotations.*;

/**
 * Created by lyj on 2018/10/25.
 */
public interface BlogUserMapper {

    // 使用xml方式
    BlogUser getBlogUserByName(String userName);

    @Select("select * from nx_user where id = #{id}")
    BlogUser getBlogUserById(Long id);

    @Select("select * from nx_user where id = #{id} and username=#{userName}")
    BlogUser getBlogUserByIdAndName(@Param("id") Long id, @Param("userName") String userName);

    @Select("select * from nx_user where id = #{id}")
    @Results({
            @Result(property = "userName", column = "username"),
            @Result(property = "password", column = "password")
    })
    BlogUser getBlogUserByIds(Long id);

    @Select("select * from nx_user where id = #{id}")
    @ResultMap("BaseResultMap")
    BlogUser getBlogUser(Long id);


    @Insert("insert into nx_user (nickname, username, password, email, type, avator) values (#{nickName}, #{userName}, #{password}, #{email}, #{type}, #{avator})")
    Integer insertBlogUser(BlogUser blogUser);

}
