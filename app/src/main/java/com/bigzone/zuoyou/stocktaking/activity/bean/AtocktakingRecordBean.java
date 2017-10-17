package com.bigzone.zuoyou.stocktaking.activity.bean;

/**
 * Created by sszz on 2017/9/19.
 */

public class AtocktakingRecordBean {
    private String Record;
    private String num;

    public AtocktakingRecordBean(String record, String num) {
        Record = record;
        this.num = num;
    }

    public String getRecord() {
        return Record;
    }

    public void setRecord(String record) {
        Record = record;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
