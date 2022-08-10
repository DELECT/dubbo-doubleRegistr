package com.dubbo.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dubbo.demo.common.AjaxResult;
import com.dubbo.demo.common.CustomBlockHandler;
import com.dubbo.demo.service.NacosServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/test/nacos")
public class TestNacosDubboController {

    @Resource
    NacosServiceImpl nacosService;

    //测试自定义限流规则
    @GetMapping("/customBlockHandler")
    @SentinelResource(value = "testBlockHandler", blockHandler = "handleException", blockHandlerClass = CustomBlockHandler.class)
    public AjaxResult blockHandler() {
        return AjaxResult.success("请求成功");
    }

    @GetMapping("/testRequest")
    @SentinelResource(value = "byDubbo", blockHandler = "flowRuleHandle")
    public AjaxResult testRequest() {
        return AjaxResult.success("测试请求");
    }

    @GetMapping(value = "/getDubbo")
    @SentinelResource(value = "byDubbo", blockHandler = "flowRuleHandle")
    public String testDubbo() {
        return nacosService.sayHello();
    }

    public AjaxResult flowRuleHandle() {
        return AjaxResult.error("限流中，请稍后重试");
    }

}
