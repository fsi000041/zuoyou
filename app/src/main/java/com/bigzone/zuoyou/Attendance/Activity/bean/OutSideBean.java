package com.bigzone.zuoyou.Attendance.Activity.bean;

/**
 * Created by sszz on 2017/9/12.
 */

public class OutSideBean {
    private String time;
    private String things;
    private String address;



    public OutSideBean(String time, String things, String address) {
        this.time = time;
        this.things = things;
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
