package com.dubbo.demo;

import com.alibaba.fastjson.JSONArray;
import com.dubbo.demo.model.TestJSON;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class JSONToObjectTest {

    @Test
    public void testJSONToObj(){
        String jsonStr= "[{\"num\":1263225674,\"name\":\"tom\"},{\"num\":1659516493,\"name\":\"tom\"}]";
        List<TestJSON> testJSONS = JSONArray.parseArray(jsonStr, TestJSON.class);
        System.out.println(testJSONS);
    }
}
