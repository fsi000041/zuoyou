package com.bigzone.zuoyou.sign.bean;

/**
 * Created by haohongwei on 2017/9/27.
 */

public class GoodsEntity {
    private String name;
    private String count;
    private String image;

    public GoodsEntity() {
    }

    public GoodsEntity(String name, String count, String image) {
        this.name = name;
        this.count = count;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
