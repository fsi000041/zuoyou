package com.bigzone.zuoyou.stocktaking.activity.bean;

import java.util.List;

/**
 * Created by sszz on 2017/9/15.
 */

public class GoodsFatherBean {
    private String bianhao;
    private String xinghao;
    private String name;
    private List<GoodsSonBean> goodsSonList;


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

    public List<GoodsSonBean> getGoodsSonList() {
        return goodsSonList;
    }

    public void setGoodsSonList(List<GoodsSonBean> goodsSonList) {
        this.goodsSonList = goodsSonList;
    }



    public static class GoodsSonBean {
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

    }
}
