package com.bigzone.zuoyou.arrange.bean;

/**
 * Created by haohongwei on 2017/9/18.
 */

public class ImportDataEntity {
    private String num;
    private String info;
    private String address;
    private String date;
    private boolean isImport;

    @Override
    public String toString() {
        return "ImportDataEntity{" +
                "num='" + num + '\'' +
                ", info='" + info + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", isImport=" + isImport +
                '}';
    }

    public ImportDataEntity() {
    }

    public ImportDataEntity(String num, String info, String address, String date, boolean isImport) {
        this.num = num;
        this.info = info;
        this.address = address;
        this.date = date;
        this.isImport = isImport;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isImport() {
        return isImport;
    }

    public void setImport(boolean anImport) {
        isImport = anImport;
    }
}
