package com.lyj.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lyj on 2018/10/28.
 */
@Component
public class MyServletRequestListener implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        logger.info("session id 为：{}",request.getRequestedSessionId());
        logger.info("request url 为 ：{}",request.getRequestURL());

        request.setAttribute("name","李依金");
    }

    @Override
    public void requestDestroyed (ServletRequestEvent servletRequestEvent) {
        logger.info("request end");
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        logger.info("request域中保存的name值为：{}",request.getAttribute("name"));
    }
}
