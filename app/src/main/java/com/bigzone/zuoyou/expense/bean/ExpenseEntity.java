package com.bigzone.zuoyou.expense.bean;

/**
 * Created by haohongwei on 2017/9/6.
 */

public class ExpenseEntity {
    private String date;
    private String project;
    private String num;
    private String money;

    @Override
    public String toString() {
        return "ExpenseEntity{" +
                "date='" + date + '\'' +
                ", project='" + project + '\'' +
                ", num='" + num + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public ExpenseEntity() {
    }

    public ExpenseEntity(String date, String project, String num, String money) {
        this.date = date;
        this.project = project;
        this.num = num;
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
