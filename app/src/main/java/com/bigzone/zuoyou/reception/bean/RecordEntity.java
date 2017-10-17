package com.bigzone.zuoyou.reception.bean;

/**
 * Created by haohongwei on 2017/8/9.
 */

public class RecordEntity {
    private int status;
    private String name;
    private String time;
    private String man;

    @Override
    public String toString() {
        return "RecordEntity{" +
                "status=" + status +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", man='" + man + '\'' +
                '}';
    }

    public RecordEntity() {
    }

    public RecordEntity(int status, String name, String time, String man) {
        this.status = status;
        this.name = name;
        this.time = time;
        this.man = man;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }
}
