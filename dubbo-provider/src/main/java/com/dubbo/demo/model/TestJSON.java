package com.dubbo.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TestJSON implements Serializable {

    public int num;
    public String name;
}
