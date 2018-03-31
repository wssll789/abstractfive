package com.abstractfive.controller;

import com.abstractfive.service.MultithreadTestService;
import com.abstractfive.service.MultithreaddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试
 * Created by 张老师 on 2018/3/31.
 */
@RestController
@RequestMapping(value = "/abstractFive")
public class AbstractFiveController {
    private Object lock = new Object();
    int taskSize = 30;//线程数

    @Autowired
    private MultithreadTestService multithreadTestService;
    /**
     * 多线程测试
     * @return
     */
    @RequestMapping("/multithread")
    public String multithread() {
        //30个线程
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        synchronized (lock){
            //1000个任务
           for(int i=0;i<1000;i++){
                //分配任务
                MultithreaddingService multithreaddingService = new MultithreaddingService(i + "", i, multithreadTestService);
                pool.submit(multithreaddingService);
            }
        }
        pool.shutdown();
        return "ojbk";
    }
}
