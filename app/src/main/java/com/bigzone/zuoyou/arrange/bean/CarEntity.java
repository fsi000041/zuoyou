package com.bigzone.zuoyou.arrange.bean;

/**
 * Created by haohongwei on 2017/9/15.
 */

public class CarEntity {
    private String name;
    private String num;

    public CarEntity(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public CarEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
