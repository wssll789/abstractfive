package com.abstractfive.service.impl;

import com.abstractfive.service.MultithreadTestService;
import org.springframework.stereotype.Service;

/**
 * 多线程测试
 * Created by 张老师 on 2018/3/31.
 */
@Service("multithreadTestService")
public class MultithreadTestServiceImpl implements MultithreadTestService {
    @Override
    public void multithreadingContent(Object record) {
        //普通业务代码均可
        System.out.println(record);
    }
}
