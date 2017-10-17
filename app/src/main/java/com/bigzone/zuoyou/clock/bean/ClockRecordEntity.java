package com.bigzone.zuoyou.clock.bean;

import java.util.List;

/**
 * Created by haohongwei on 2017/8/17.
 */

public class ClockRecordEntity {
    private List<ItemRecordEntity> timeEntityList;
    private String time;

    public ClockRecordEntity(List<ItemRecordEntity> timeEntityList, String time) {
        this.timeEntityList = timeEntityList;
        this.time = time;
    }

    public ClockRecordEntity() {
    }

    public List<ItemRecordEntity> getTimeEntityList() {
        return timeEntityList;
    }

    public void setTimeEntityList(List<ItemRecordEntity> timeEntityList) {
        this.timeEntityList = timeEntityList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
