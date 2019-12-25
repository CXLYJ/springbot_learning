package com.lyj.exception;

import com.lyj.entity.JsonResult;
import com.lyj.entity.JsonResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lyj on 2018/10/24.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private  final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 拦截业务异常，返回业务异常信息
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResults handlebusinessError(BusinessErrorException ex){
        String code = ex.getCode();
        String msg = ex.getMessage();
        return new JsonResults(code,msg);
    }

    /**
     * 缺少请求参数
     * @param ex
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResults handleHttpMessageNotReadableException(MissingServletRequestParameterException ex){
            log.error("缺少请求参数，{}",ex.getMessage());
            return new JsonResults("400","缺少必要的请求参数");
    }

    /**
     * 空指针异常
     * @param ex NullPointerException
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResults handleTypeMismatchException(NullPointerException ex) {
        log.error("空指针异常，{}", ex.getMessage());
        return new JsonResults("500", "空指针异常了");
    }

    /**
     * 系统异常 预期以外异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResults handleUnexpectedServer(Exception ex) {
        log.error("系统异常：", ex);
        return new JsonResults("500", "系统发生异常，请联系管理员");
    }

}
