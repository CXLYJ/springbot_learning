package com.lyj.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyj.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by lyj on 2018/10/29.
 * 解决中文乱码（此WebMvcConfigurerAdapter方法被废弃）
 */
//@Configuration
//@EnableWebMvc
//@ComponentScan
//public class MvcConfiguration extends WebMvcConfigurerAdapter {
//
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter(){
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        return converter;
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//
//        converters.add(responseBodyConverter());
//    }
//
//}


/**
 * 基本上就解决了乱码问题。
  */
//@Configuration
//public class MvcConfiguration extends WebMvcConfigurationSupport {
//
//    @Bean
//     public HttpMessageConverter<String> responseBodyConverter() {
//               StringHttpMessageConverter converter = new StringHttpMessageConverter(
//                           Charset.forName("UTF-8"));
//                return converter;
//            }
//
//   public void configureMessageConverters(
//            List<HttpMessageConverter<?>> converters) {
//              super.configureMessageConverters(converters);
//               converters.add(responseBodyConverter());
//            }
//
//    public void configureContentNegotiation(
//             ContentNegotiationConfigurer configurer) {
//                 configurer.favorPathExtension(false);
//           }
//
//}


/**
 *如果出现org.springframework.http.converter.HttpMessageNotWritableException:
 * No converter found for return value of type: class java.util.LinkedHashMap
 * 就需要在配置类中，添加一些代码，完整的代码如下：
 */
//@Configuration
//public class MvcConfiguration extends WebMvcConfigurationSupport {
//
//    /**
//     * 解决中文乱码问题
//     */
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
//    }
//
//    @Bean
//    public ObjectMapper getObjectMapper() {
//        return new ObjectMapper();
//    }
//    @Bean
//    public MappingJackson2HttpMessageConverter messageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setObjectMapper(getObjectMapper());
//        return converter;
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//           super.configureMessageConverters(converters);
//            //解决中文乱码
//            converters.add(responseBodyConverter());
//           //解决 添加解决中文乱码后 上述配置之后，返回json数据直接报错 500：no convertter for return value of type
//           converters.add(messageConverter());
//            converters.add(responseBodyConverter());
//           }
//
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//            configurer.favorPathExtension(false);
//    }

    /**
      * 用来指定静态资源不被拦截,否则继承WebMvcConfigurationSupport这种方式会导致静态资源无法直接访问
      * @param registry
      */
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        //配置不被拦截的路径
//        registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/swagger-resources/**");
//    }

//}