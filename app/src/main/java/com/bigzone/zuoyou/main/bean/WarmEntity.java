package com.bigzone.zuoyou.main.bean;

import com.bigzone.zuoyou.sales.bean.SalesDetailEntity;

/**
 * Created by haohongwei on 2017/8/25.
 */

public class WarmEntity {
    private int status;
    private String title;
    private String content;
    private boolean isRead;
    private String time;

    public WarmEntity() {
    }

    public WarmEntity(int status, String title, String content, boolean isRead, String time) {
        this.status = status;
        this.title = title;
        this.content = content;
        this.isRead = isRead;
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
