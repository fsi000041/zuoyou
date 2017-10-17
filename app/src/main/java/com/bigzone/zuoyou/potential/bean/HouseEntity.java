package com.bigzone.zuoyou.potential.bean;

/**
 * Created by haohongwei on 2017/8/15.
 */

public class HouseEntity {

    private String name;
    private String time;
    private String mode;

    public HouseEntity() {
    }

    public HouseEntity(String name, String time, String mode) {
        this.name = name;
        this.time = time;
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}

