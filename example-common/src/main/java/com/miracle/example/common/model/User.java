package com.miracle.example.common.model;

import java.io.Serializable;

/**
 * @author dargon
 * @create 2024-02-25
 * @description 用户
 */
public class User implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}