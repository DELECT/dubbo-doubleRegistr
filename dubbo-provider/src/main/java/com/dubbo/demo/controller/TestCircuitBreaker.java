package com.dubbo.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dubbo.demo.common.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author xingyu
 * @Description 测试sentinel熔断器的规则demo
 **/
@RestController
public class TestCircuitBreaker {

    /**
     * @return com.dubbo.demo.common.AjaxResult
     * @Author xingyu
     * @Description 如果1秒内持续进入大于等于5个请求，并且请求响应的时间大于200ms时，
     * 这个请求即为慢调用，当慢调用的比例大于1时会触发降级，直到5秒后新的请求的响应时间小于200ms时，才结束熔断。
     * @Date 12:18 2022/8/3
     **/
    @GetMapping("/TEST_SLOW_REQUEST_RATIO")
    @SentinelResource(value = "TEST_SLOW_REQUEST_RATIO_VALUE")
    public AjaxResult testRequest() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return AjaxResult.success("测试熔断策略慢调用比例");
    }

    /**
     * @Author xingyu
     * @Description 如果1秒内持续进入大于等于5个请求，并且请求中报异常的比例超过0.2则触发降级(降级时间持续5秒)，5秒后，新的请求若正常返回，才结束熔断。
     * @Date 17:49 2022/8/3
     **/
    @GetMapping("/TEST_ERROR_RATIO")
    @SentinelResource(value = "TEST_ERROR_RATIO_VALUE")
    public AjaxResult testErrorRatio() {
        int num = 1 / 0;
        return AjaxResult.success("测试熔断策略异常比例");
    }

    /**
     * @Author xingyu
     * @Description  如果1秒内持续进入大于等于5个请求，并且请求异常数超过5时，会触发降级(降级时间持续5秒)，5秒后，新的请求若正常返回，才结束熔断。
     * @Date 9:26 2022/8/4
     **/
    @GetMapping("/TEST_ERROR_COUNT")
    @SentinelResource(value = "TEST_ERROR_COUNT_VALUE")
    public AjaxResult testErrorCount() {
        int num = 1 / 0;
        return AjaxResult.success("测试熔断策略异常数");
    }


}
