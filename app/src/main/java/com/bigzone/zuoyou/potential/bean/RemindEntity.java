package com.bigzone.zuoyou.potential.bean;

/**
 * Created by haohongwei on 2017/8/14.
 */

public class RemindEntity {
    private String time;
    private String name;
    private String content;
    private boolean status;

    @Override
    public String toString() {
        return "RemindEntity{" +
                "time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public RemindEntity() {
    }

    public RemindEntity(String time, String name, String content, boolean status) {
        this.time = time;
        this.name = name;
        this.content = content;
        this.status = status;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

