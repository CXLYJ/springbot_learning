package com.lyj.service;

import com.alibaba.fastjson.JSON;
import com.lyj.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lyj on 2018/10/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceTest.class);

    @Resource
    private RedisService redisService;

    @Test
    public void test(){
        //测试redis的string类型
        redisService.setString("lyj","李依金");
        logger.info("我的名字：{}",redisService.getString("lyj"));

        // 如果是个实体，我们可以使用json工具转成json字符串
        User user = new User(1,"lyj","123456");
        redisService.setString("userInfo", JSON.toJSONString(user));
        logger.info("用户信息：{}",redisService.getString("userInfo"));

        //测试Redis的hash类型
        redisService.setHash("user", "name", JSON.toJSONString(user));
        logger.info("用户姓名：{}", redisService.getHash("user","name"));


        //测试redis的list类型
        redisService.setList("list", "football");
        redisService.setList("list", "basketball");
        List<String> valList = redisService.getList("list",0,-1);
        for(String value :valList){
            logger.info("list中有：{}", value);
        }

    }

    @Test
    public void work(){
        //设置redis的过期时间
        redisService.setTimeOut("lyj",60);
    }

    @Test
    public void task(){
        //设置redis的值并设置失效时间
        redisService.setCachesData("123","123",60);
    }

}