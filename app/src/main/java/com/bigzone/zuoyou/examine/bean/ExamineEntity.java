package com.bigzone.zuoyou.examine.bean;

/**
 * Created by haohongwei on 2017/9/6.
 */

public class ExamineEntity {
    private String date;
    private String project;
    private String num;

    @Override
    public String toString() {
        return "ExpenseEntity{" +
                "date='" + date + '\'' +
                ", project='" + project + '\'' +
                ", num='" + num + '\'' +
                '}';
    }

    public ExamineEntity() {
    }

    public ExamineEntity(String date, String project, String num) {
        this.date = date;
        this.project = project;
        this.num = num;
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

}
