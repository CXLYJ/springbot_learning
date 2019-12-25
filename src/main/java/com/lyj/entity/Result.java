package com.lyj.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyj on 2018/12/21.
 */
public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = -7917558214367195051L;

    public static Result ok(){
        return new Result();
    }

    public Result(){
        put("code",0);
        put("msg","操作成功");
    }

    public static Result error() {
        return error(500, "发生异常，请联系管理员");
    }

    /**
     * 设置错误信息
     * @param code
     * @param msg
     * @return
     */
    public static Result error(int code,String msg){
        Result result = new Result();
        result.put("code",code);
        result.put("msg", msg);
        return  result;
    }

    public static Result error(String code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    /**
     * 设置正确信息
     * @param msg
     * @return
     */
    public static Result ok(String msg){
        Result result = new Result();
        result.put("msg",msg);
        return result;
    }

    public static Result ok(String code, String msg){
        Result result = new Result();
        result.put("code",code);
        result.put("msg",msg);
        return result;
    }

    public static Result ok(Map<String, Object> map){
        Result result = new Result();
        result.putAll(map);
        return result;
    }

    /**
     * 重写put的方法设置
     * @param key
     * @param value
     * @return
     */
    public Result put(String key, Object value){
        super.put(key,value);
        return this;
    }

}
