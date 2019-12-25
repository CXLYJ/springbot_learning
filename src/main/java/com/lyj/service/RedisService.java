package com.lyj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lyj on 2018/10/30.
 */
@Service
public class RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * set redis : string类型
     * @param key key
     * @param value value
     */
    public void setString(String key,String value){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key,value);
    }

    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * set redis: hash类型
     * @param key key
     * @param filedKey filedkey
     * @param value value
     */
    public void setHash(String key, String filedKey, String value){
        HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put(key,filedKey, value);
    }

    /**
     * get redis: hash类型
     * @param key key
     * @param filedkey filedkey
     * @return
     */
    public String getHash(String key, String filedkey){
        return (String) stringRedisTemplate.opsForHash().get(key, filedkey);
    }


    /**
     * set redis:list类型
     * @param key key
     * @param value value
     * @return
     */
    public long setList(String key, String value){
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        return listOperations.leftPush(key, value);
    }

    /**
     * get redis:list类型
     * @param key key
     * @param start start
     * @param end end
     * @return
     */
    public List<String> getList(String key, long start, long end) {
        return stringRedisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 设置key失效时间
     * @param key key
     * @param timeout timeout
     * @return
     */
    public boolean setTimeOut(String key, long timeout){
        return stringRedisTemplate.expire(key,timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置值并设置失效时间
     * @param key
     * @param value
     * @param timeOut
     */
    public void setCachesData(String key,String value,long timeOut){
        if (logger.isDebugEnabled()) {
            logger.debug("String, String, int - start"); //$NON-NLS-1$
        }
        setString(key,value);
        setTimeOut(key,timeOut);
        if (logger.isDebugEnabled()) {
            logger.debug("String, String, int - start"); //$NON-NLS-1$
        }
    }


}
