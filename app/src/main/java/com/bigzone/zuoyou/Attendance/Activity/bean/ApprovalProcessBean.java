package com.bigzone.zuoyou.Attendance.Activity.bean;

/**
 * Created by sszz on 2017/9/11.
 */

public class ApprovalProcessBean {
    private String name ;
    private String name1;


    public ApprovalProcessBean(String name, String name1) {
        this.name = name;
        this.name1 = name1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    @Override
    public String toString() {
        return "ApprovalProcessBean{" +
                "name='" + name + '\'' +
                ", name1='" + name1 + '\'' +
                '}';
    }

}
