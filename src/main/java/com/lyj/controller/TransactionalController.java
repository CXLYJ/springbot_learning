package com.lyj.controller;

import com.lyj.entity.BlogUser;
import com.lyj.service.BlogUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lyj on 2018/10/26.
 */
@RestController
@RequestMapping("/transactional")
@Api(value = "事务回滚测试")
public class TransactionalController {

    @Resource
    private BlogUserService blogUserService;

    /**
     * 测试事务 可回滚异常
     * @param blogUser
     * @return
     * @throws Exception
     */
    @PostMapping("/adduser")
    public String addUser(/*@RequestBody*/ BlogUser blogUser) throws Exception {
        if (null != blogUser) {
            blogUserService.insertUser(blogUser);
            return "success";
        } else {
            return "false";
        }
    }

    /**
     * 测试事务 不可回滚异常
     * 异常并没有被捕获到
     * @param blogUser
     * @return
     * @throws Exception
     */
    @PostMapping("/adduser2")
    public String addUser2(/*@RequestBody*/ BlogUser blogUser) throws Exception {
        if (null != blogUser) {
            blogUserService.insertUser2(blogUser);
            return "success";
        } else {
            return "false";
        }
    }

    /**
     * 测试事务
     * 不可回滚
     * 异常被吃掉
     * @param blogUser
     * @return
     * @throws Exception
     */
    @PostMapping("/adduser3")
    public String addUser3(/*@RequestBody*/ BlogUser blogUser) throws Exception {
        if (null != blogUser) {
            blogUserService.insertUser3(blogUser);
            return "success";
        } else {
            return "false";
        }
    }

    /**
     * 测试事务
     * 可回滚
     *
     * @param blogUser
     * @return
     * @throws Exception
     */
    @PostMapping("/adduser4")
    public String addUser4(/*@RequestBody*/ BlogUser blogUser) throws Exception {
        if (null != blogUser) {
            blogUserService.insertUser4(blogUser);
            return "success";
        } else {
            return "false";
        }
    }

}
