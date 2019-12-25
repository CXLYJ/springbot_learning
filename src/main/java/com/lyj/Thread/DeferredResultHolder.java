package com.lyj.Thread;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyj on 2018/11/13.
 * 订单处理情况 中介/持有者
 */
@Component
public class DeferredResultHolder {

    /**
     * String： 订单号
     * DeferredResult：处理结果
     */
    private Map<String,DeferredResult> map = new HashMap<>();

    public Map<String, DeferredResult> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult> map) {
        this.map = map;
    }
}
