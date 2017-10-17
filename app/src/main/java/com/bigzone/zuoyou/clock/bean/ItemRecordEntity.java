package com.bigzone.zuoyou.clock.bean;

/**
 * Created by haohongwei on 2017/8/17.
 */

public class ItemRecordEntity {
    private String time;
    private String content;

    public ItemRecordEntity(String time, String content) {
        this.time = time;
        this.content = content;
    }

    public ItemRecordEntity() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
