package com.bigzone.zuoyou.Attendance.Activity.bean;

/**
 * Created by sszz on 2017/9/8.
 */
public class WorkOverTimeBean {
    private String jiaban;
    private String danhao;
    private String state;


    @Override
    public String toString() {
        return "WorkOverTimeBean{" +
                "jiaban='" + jiaban + '\'' +
                ", danhao='" + danhao + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public WorkOverTimeBean() {
    }

    public WorkOverTimeBean(String danhao, String state, String jiaban) {
        this.danhao = danhao;
        this.jiaban = jiaban;
        this.state = state;
    }

    public String getJiaban() {
        return jiaban;
    }

    public void setJiaban(String jiaban) {
        this.jiaban = jiaban;
    }

    public String getDanhao() {
        return danhao;
    }

    public void setDanhao(String danhao) {
        this.danhao = danhao;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
