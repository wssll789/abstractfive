package com.abstractfive.service;

import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by 张老师 on 2018/3/31.
 */
public class MultithreaddingService implements Callable<Object> {

    private static org.slf4j.Logger multiThreadLogger = LoggerFactory.getLogger("multiThreadLogger");

    private String taskNum;
    private Object record;
    private BaseService baseService;

    public MultithreaddingService(String taskNum, BaseService baseService) {
        this.taskNum = taskNum;
        this.baseService = baseService;
    }
    public MultithreaddingService(String taskNum, Object record, BaseService baseService) {
        this.taskNum = taskNum;
        this.record = record;
        this.baseService = baseService;
    }

    @Override
    public Object call() throws Exception {
        Long startTime=System.currentTimeMillis();
        try{
            baseService.multithreadingContent(record);
        }catch (Exception e){
            multiThreadLogger.error("执行分配任务出错",e);
        }
        Long endTime=System.currentTimeMillis();
        long time = startTime - endTime;
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }
}
