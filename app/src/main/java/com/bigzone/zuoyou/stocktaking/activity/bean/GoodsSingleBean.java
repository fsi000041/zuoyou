package com.bigzone.zuoyou.stocktaking.activity.bean;

/**
 * Created by sszz on 2017/9/18.
 */

public class GoodsSingleBean {
    private String bianhao;
    private String xinghao;
    private String name;

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public String getXinghao() {
        return xinghao;
    }

    public void setXinghao(String xinghao) {
        this.xinghao = xinghao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoodsSingleBean(String bianhao, String xinghao, String name) {
        this.bianhao = bianhao;
        this.xinghao = xinghao;
        this.name = name;
    }


}
