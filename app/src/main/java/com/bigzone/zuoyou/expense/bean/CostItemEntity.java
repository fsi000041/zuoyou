package com.bigzone.zuoyou.expense.bean;

/**
 * Created by haohongwei on 2017/9/6.
 */

public class CostItemEntity {
    private String name;
    private String note;
    private String money;

    @Override
    public String toString() {
        return "CostItemEntity{" +
                "name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public CostItemEntity() {
    }

    public CostItemEntity(String name, String note, String money) {
        this.name = name;
        this.note = note;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
