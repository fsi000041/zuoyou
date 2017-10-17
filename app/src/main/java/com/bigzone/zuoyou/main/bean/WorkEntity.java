package com.bigzone.zuoyou.main.bean;

/**
 * Created by 郝宏伟 on 2016-12-01.
 */

public class WorkEntity {
    private int img;
    private String name;

    public WorkEntity() {
    }

    public WorkEntity(int img, String name) {
        this.img = img;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
