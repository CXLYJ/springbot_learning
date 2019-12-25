package com.lyj.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyj.annotation.UnInterception;
import com.lyj.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by lyj on 2018/10/30.
 */
@Configuration
public class MyInterceptorRegistry implements WebMvcConfigurer {

        /**
     * 解决中文乱码问题
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
    @Bean
    public MappingJackson2HttpMessageConverter messageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(getObjectMapper());
        return converter;
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//           super.configureMessageConverters(converters);
//            //解决中文乱码
//            converters.add(responseBodyConverter());
//           //解决 添加解决中文乱码后 上述配置之后，返回json数据直接报错 500：no convertter for return value of type
//           converters.add(messageConverter());
//            converters.add(responseBodyConverter());
//           }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
            configurer.favorPathExtension(false);
    }

    /**
     * 自定义拦截器的配置，实现WebMvcConfigurer不会导致Spring Boot对mvc的自动配置失效，可以用在非前后端分离的项目中
     *
     * 使用此注解要将自定义拦截器MyInterceptor的preHandle方法里对注解的代码去掉，因为请求静态资源是没有注解的（否者后台会报错）
     */
    public void addInterceptors(InterceptorRegistry registry) {
        // 实现WebMvcConfigurer不会导致静态资源被拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        //配置不被拦截的路径
        registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/swagger-resources/**");
    }

}
