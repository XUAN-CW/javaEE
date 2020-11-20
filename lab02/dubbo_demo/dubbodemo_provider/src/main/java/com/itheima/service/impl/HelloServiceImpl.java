package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.service.HelloService;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = HelloService.class,protocol = "dubbo") //发布服务必须使用Dubbo提供的Service注解
@Transactional
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "provide service for : " + name;
    }

    @Override
    public String add(int addend1, int addend2) {
        int he = addend1+addend2;
        String a=String.valueOf(he);
        return a;
    }
}
