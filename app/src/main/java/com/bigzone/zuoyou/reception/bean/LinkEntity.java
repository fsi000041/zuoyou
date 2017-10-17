package com.bigzone.zuoyou.reception.bean;

/**
 * Created by haohongwei on 2017/8/9.
 */

public class LinkEntity {
    private String name;
    private String phone;

    public LinkEntity() {
    }

    public LinkEntity(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
