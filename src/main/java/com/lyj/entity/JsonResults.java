package com.lyj.entity;

/**
 * Created by lyj on 2018/10/24.
 */
public class JsonResults {

    /**
     * 异常码
     */
    protected String code;

    /**
     * 异常信息
     */
    protected String msg;

    public JsonResults() {
        this.code = "200";
        this.msg = "操作成功";
    }

    public JsonResults(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

//    public JsonResult(BusinessErrorException ex) {
//        this.code = ex.getCode();
//        this.msg = ex.getMessage();
//    }
//
//    public JsonResult(BusinessMsgEnum msg) {
//        this.code = msg.code();
//        this.msg = msg.msg();
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
