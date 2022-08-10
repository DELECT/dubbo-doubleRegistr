package com.dubbo.demo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dubbocommon.service.IDubboService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(registry = {"provider1"})
public class NacosServiceImpl implements IDubboService {

    @Override
    @SentinelResource(value = "byDubbo")
    public String sayHello() {
        return "hello nacos";
    }
}
