package com.lyj.config;

import com.lyj.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by lyj on 2018/10/29.
 * 自定义拦截器的配置，继承WebMvcConfigurationSupport会导致Spring Boot对mvc的自动配置失效，但可以在前后端分离项目中
 * 如果需要让Spring Boot的自动配置生效，需要重写addResourceHandlers方法，将自动配置的路径放开
 */
//@Configuration
//public class MyInterceptorConfig extends WebMvcConfigurationSupport {
//
//    //此方式静态资源会被拦截（不适用）
////    protected void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
////        super.addInterceptors(registry);
////    }
//
//    /**
//     * 用来指定静态资源不被拦截，否则继承WebMvcConfigurationSupport这种方式会导致静态资源无法直接访问
//     * @param registry
//     */
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//
//
//    /**
//     * 自定义拦截器的配置，实现WebMvcConfigurer不会导致Spring Boot对mvc的自动配置失效，可以用在非前后端分离的项目中
//     */
////    public void addInterceptors(InterceptorRegistry registry) {
////        // 实现WebMvcConfigurer不会导致静态资源被拦截
////        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
////    }
//
//}
