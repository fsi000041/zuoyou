package com.bigzone.zuoyou.Attendance.Activity.bean;

/**
 * Created by sszz on 2017/9/8.
 */
public class AskForLeaveBean {
    private String date;
    private String num;
    private String state;


    @Override
    public String toString() {
        return "AskForLeaveBean{" +
                "date='" + date + '\'' +
                ", num='" + num + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public AskForLeaveBean() {
    }

    public AskForLeaveBean(String date, String state, String num) {
        this.date = date;
        this.num = num;
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
