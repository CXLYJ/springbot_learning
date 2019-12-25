package com.lyj.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lyj on 2018/10/24.
 */
@Aspect
@Component
public class LogAspectHandler {

    private final  static Logger logger = LoggerFactory.getLogger(LogAspectHandler.class);

    /**
     * 任意公共方法的执行：
     　　　　execution(public * *(..))
     　　任何一个以“set”开始的方法的执行：
     　　　　execution(* set*(..))
     　　AccountService 接口的任意方法的执行：
     　　　　execution(* com.xyz.service.AccountService.*(..))
     　　定义在service包里的任意方法的执行：
     　　　　execution(* com.lyj.service.*.*(..))
     　　定义在service包和所有子包里的任意类的任意方法的执行：
     　　　　execution(* com.lyj.service..*.*(..))
     　　定义在pointcutexp包和所有子包里的JoinPointObjP2类的任意方法的执行：
     　　　　execution(* com.test.spring.aop.pointcutexp..JoinPointObjP2.*(..))")
     */


    /**
     * 只对AopController进行切面处理
     */
    @Pointcut("execution(* com.lyj.controller.AopController.*(..))")
    public void pointCut(){}

    /**
     * 异常测试aop
     */
//    @Pointcut("execution(* com.lyj.controller..*.*(..))")
//    public void pointCut(){}

    /**
     * 在定义切面方法执行之前执行该方法
     * @param joinPoint
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("----------doBeafore方法进入------------");

        //获取签名
        Signature signature = joinPoint.getSignature();
        //获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        //获取即将执行的方法名
        String funcName = signature.getName();
        logger.info("即将执行的方法为：{} 属于{}包",funcName,declaringTypeName);

        // 也可以用来记录一些信息，比如获取请求的url和ip
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取请求url
        String url = request.getRequestURL().toString();
        // 获取请求ip
        String ip = request.getRemoteAddr();
        logger.info("用户请求的url为：{}，ip地址为：{}", url, ip);
    }

    /**
     * 在定义切面方法执行之后执行该方法
     * @param joinPoint
     */
    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        logger.info("-------------doAfter方法进入-------------");
        //获取签名
        Signature signature = joinPoint.getSignature();
        String funcName = signature.getName();
        logger.info("该{}方法执行完成",funcName);
    }

    /**
     * 在上面定义的切面方法返回后执行该方法（即切面方法执行之后执行），可以捕获返回对象或者对返回对象进行增强
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void doAfterReturning(JoinPoint joinPoint,Object result){
        logger.info("-------------doAfterReturning方法进入----------");
        //获取签名
        Signature signature = joinPoint.getSignature();
        String pointName = signature.getName();
        logger.info("方法{}执行完毕，返回参数为：{}",pointName,result);
        // 实际项目中可以根据业务做具体的返回值增强
        logger.info("对返回参数进行业务上的增强：{}", result + " 增强版");
    }

    /**
     * 在上面定义的切面方法执行抛异常时，执行该方法
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(pointcut = "pointCut()",throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable ex){
        logger.info("-----------doAfterThrowing方法进入-----------------");
        Signature signature = joinPoint.getSignature();
        String pointName = signature.getName();
        //处理异常逻辑
        logger.info("执行方法{}出现异常，异常为：{}",pointName,ex);
    }

}
