package com.bigzone.zuoyou.potential.bean;

/**
 * Created by haohongwei on 2017/8/23.
 */

public class ScheduleEntity {
    private String name;
    private String status;

    public ScheduleEntity(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public ScheduleEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
