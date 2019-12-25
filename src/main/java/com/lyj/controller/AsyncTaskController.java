package com.lyj.controller;

import com.lyj.entity.JsonResult;
import com.lyj.quartz.AsyncTask;
import com.lyj.quartz.AsyncTasks;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * Created by lyj on 2018/11/4.
 * 异步定时任务
 */
@RestController
@RequestMapping("/async")
@Api(value = "异步定时任务")
public class AsyncTaskController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTaskController.class);

    @Resource
    private AsyncTask asyncTask;

    @Resource
    private AsyncTasks asyncTasks;

    @GetMapping(value = "/task")
    public JsonResult account(){
        long start = System.currentTimeMillis();
        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();
        long end = System.currentTimeMillis();
        long total = end - start; //此时异步任务不需要等待三个任务完成，而是直接返回，大大提高了执行的效率
        logger.info("总耗时：" + total);
        return new  JsonResult<>(total);
    }

    /**
     * 1）要把异步任务封装到类里面，不能直接写到Controller
     * 2）增加Future<String> 返回结果 AsyncResult<String>("task执行完成");  
     * 3）如果需要拿到结果 需要判断全部的 task.isDone()
     * @return
     */
    @GetMapping(value = "/tasks")
    public JsonResult accounts(){
        long start = System.currentTimeMillis();
//        asyncTask.task1();
//        asyncTask.task2();
//        asyncTask.task3();
        Future<String> task4 = asyncTasks.task4();
        Future<String> task5 = asyncTasks.task5();
        Future<String> task6 = asyncTasks.task6();
        for (;;){ //三个任务执行完跳出
            if (task4.isDone() && task5.isDone() && task6.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis();
        long total = end - start;
        logger.info("总耗时：" + total);
        return new  JsonResult<>(total);
    }

}
