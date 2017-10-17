package com.bigzone.zuoyou.sign.bean;

/**
 * Created by haohongwei on 2017/9/26.
 */

public class SignEntity {
    private String num;
    private String date;
    private String address;
    private boolean isSign;

    public SignEntity() {
    }

    public SignEntity(String num, String date, String address, boolean isSign) {
        this.num = num;
        this.date = date;
        this.address = address;
        this.isSign = isSign;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }
}
