package com.bigzone.zuoyou.potential.bean;

/**
 * Created by haohongwei on 2017/8/14.
 */

public class WishEntity {
    private String title;
    private String time;
    private String department;
    private String name;


    @Override
    public String toString() {
        return "WishEntity{" +
                "title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public WishEntity(String title, String time, String department, String name) {
        this.title = title;
        this.time = time;
        this.department = department;
        this.name = name;
    }

    public WishEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
