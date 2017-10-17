package com.bigzone.zuoyou.arrange.bean;

/**
 * Created by haohongwei on 2017/9/12.
 */

public class ArrangeEntity {
    private int status;
    private String num;
    private String time;
    private String name;

    @Override
    public String toString() {
        return "ArrangeEntity{" +
                "status=" + status +
                ", num='" + num + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public ArrangeEntity(int status, String num, String time, String name) {
        this.status = status;
        this.num = num;
        this.time = time;
        this.name = name;
    }

    public ArrangeEntity() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
