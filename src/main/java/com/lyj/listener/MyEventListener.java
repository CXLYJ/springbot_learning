package com.lyj.listener;

import com.lyj.entity.MyEvent;
import com.lyj.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by lyj on 2018/10/28.
 * 自定义事件监听
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        //把事件的信息获取到
        User user = myEvent.getUser();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等等
        logger.info("用户名：" + user.getUsername());
        logger.info("密码：" + user.getPassword());
    }
}
