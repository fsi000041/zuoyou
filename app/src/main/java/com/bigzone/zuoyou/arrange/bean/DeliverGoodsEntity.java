package com.bigzone.zuoyou.arrange.bean;

import java.util.List;

/**
 * Created by haohongwei on 2017/9/13.
 */

public class DeliverGoodsEntity {


    /**
     * name : 章鱼
     * address : 上海市
     * time : 2017-09-10
     * goods : [{"content":"亚麻布","count":"1","car":"1"}]
     */

    private String name;
    private String address;
    private String time;
    private List<GoodsBean> goods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * content : 亚麻布
         * count : 1
         * car : 1
         */

        private String content;
        private String count;
        private String car;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getCar() {
            return car;
        }

        public void setCar(String car) {
            this.car = car;
        }
    }
}
