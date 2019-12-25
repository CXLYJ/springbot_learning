package com.lyj.service.impl;

import com.lyj.dao.BlogUserMapper;
import com.lyj.entity.BlogUser;
import com.lyj.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by lyj on 2018/10/25.
 */
@Service
public class BlogUserServiceImpl implements BlogUserService {

    @Autowired
    private BlogUserMapper blogUserMapper;

    @Override
    public BlogUser getBlogUserByName(String username) {
        return blogUserMapper.getBlogUserByName(username);
    }

    @Override
    public BlogUser getBlogUserById(Long id) {
        return blogUserMapper.getBlogUserById(id);
    }

    @Override
    public BlogUser getBlogUser(Long id, String userName) {
        return blogUserMapper.getBlogUserByIdAndName(id,userName);
    }

    @Override
    public BlogUser getBlogUserByIds(Long id) {
        return blogUserMapper.getBlogUserByIds(id);
    }

    @Override
    public BlogUser getBlogUser(Long id) {
        return blogUserMapper.getBlogUser(id);
    }

    /**
     * 因为 Spring Boot 默认的事务规则是遇到运行异常（RuntimeException）和程序错误（Error）才会回滚
     * 可回滚
     * @param blogUser
     */
    @Override
    @Transactional
    public void insertUser(BlogUser blogUser) {
        // 插入用户信息
        blogUserMapper.insertBlogUser(blogUser);
        // 手动抛出异常 此异常可以回滚
        throw new RuntimeException();
    }

    /**
     * 不可回滚
     * @param blogUser
     * @throws Exception
     */
    @Override
    @Transactional
    public void insertUser2(BlogUser blogUser) throws Exception {
        // 插入用户信息
        blogUserMapper.insertBlogUser(blogUser);
        // 手动抛出异常 此异常不可以回滚
        throw new SQLException("数据库异常");
    }


    /**
     * 不可回滚
     * @param blogUser
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUser3(BlogUser blogUser){
        try {
            // 插入用户信息
            blogUserMapper.insertBlogUser(blogUser);
            // 手动抛出异常 此异常不可以回滚
            throw new SQLException("数据库异常");
        }catch (Exception e){
            // 异常处理逻辑
            e.printStackTrace();
        }
    }

    /**
     * 给上一层处理即可，千万不要在事务中把异常自己 “吃” 掉
     * 不可回滚
     * @param blogUser
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUser4(BlogUser blogUser) throws  Exception {
        // 插入用户信息
        blogUserMapper.insertBlogUser(blogUser);
        // 手动抛出异常 此异常不可以回滚
        throw new SQLException("数据库异常");
    }


    /**
     * 方法上加了事务，也就意味着，该方法开始执行时，事务启动，执行完了后，事务关闭。
     * 但 synchronized 并没有起作用，根本原因是事务的范围比锁的范围大。
     * 也就是说，在加锁的那部分代码执行完之后，锁释放掉了，但是事务还没结束。
     * 此时如果另一个线程进来，数据库的状态和第一个线程刚进来时是一样的。
     * 即由于 MySQL Innodb 引擎的默认隔离级别是可重复读（在同一个事务里，Select 的结果是事务开始时时间点的状态）的，
     * 线程二事务开始的时候，线程一还没提交完成，导致读取的数据还没更新。第二个线程也做了插入动作，从而导致了脏数据。
     *
     * * 这个问题可以避免，第一，把事务去掉即可（不推荐）；第二，（在调用该 Service 的地方加锁）。
     * * 保证锁的范围比事务的范围大即可。
     * @param blogUser
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void insertUser5(BlogUser blogUser) {
        // 插入用户信息
        blogUserMapper.insertBlogUser(blogUser);
    }

}
