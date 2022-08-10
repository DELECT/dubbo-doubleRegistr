package com.dubbo.demo.common;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

@Component
public class CustomBlockHandler {

    /**
     * @Author xingyu
     * @Description 自定义限流处理逻辑需要注意的地方：
     *              1.必须为static方法
     *              2.参数必须和原方法一致，在参数最后+BlockException
     *              3.响应必须一致
     **/
    public static AjaxResult handleException(BlockException exception){
        return AjaxResult.error(501,"自定义限流处理逻辑");
    }
}
