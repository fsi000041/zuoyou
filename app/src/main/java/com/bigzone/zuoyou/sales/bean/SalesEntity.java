package com.bigzone.zuoyou.sales.bean;

import java.util.List;

/**
 * Created by haohongwei on 2017/7/20.
 */

public class SalesEntity {

    /**
     * status : success
     * rpdata : {"count":"10","list":[{"billno":"12345678","billdate":"2017-08-03","storename":"门店001","customername":"张三","address":"南京市秦淮区洪武路222号","telephone":"13166669999","appointmenttime":"2017-08-20","salesdocno":"234565432","status":"0","closedstate":"0","isfull":"1","tfinalamount":"24300","paidamount":"0","totalquantity":"20","product":[{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发1111","quantity":"3","amount":"3000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发33311","quantity":"2","amount":"5000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发221","quantity":"4","amount":"4000"}]},{"billno":"12345678","billdate":"2017-08-03","storename":"门店001","customername":"李四","address":"南京市秦淮区洪武路222号","telephone":"13166669999","appointmenttime":"2017-08-20","salesdocno":"234565432","status":"1","closedstate":"0","isfull":"1","tfinalamount":"23400","paidamount":"0","totalquantity":"20","product":[{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发1111","quantity":"3","amount":"3000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发33311","quantity":"2","amount":"5000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发221","quantity":"4","amount":"4000"}]},{"billno":"12345678","billdate":"2017-08-03","storename":"门店001","customername":"王五","address":"南京市秦淮区洪武路222号","telephone":"13166669999","appointmenttime":"2017-08-20","salesdocno":"234565432","status":"2","closedstate":"0","isfull":"1","tfinalamount":"24300","paidamount":"0","totalquantity":"20","product":[{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发1111","quantity":"3","amount":"3000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发33311","quantity":"2","amount":"5000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发221","quantity":"4","amount":"4000"}]},{"billno":"12345678","billdate":"2017-08-03","storename":"门店001","customername":"张三fd","address":"南京市秦淮区洪武路222号","telephone":"13166669999","appointmenttime":"2017-08-20","salesdocno":"234565432","status":"2","closedstate":"0","isfull":"1","tfinalamount":"24300","paidamount":"0","totalquantity":"20","product":[{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发1111","quantity":"3","amount":"3000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发33311","quantity":"2","amount":"5000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发221","quantity":"4","amount":"4000"}]}]}
     */

    private String status;
    private RpdataBean rpdata;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RpdataBean getRpdata() {
        return rpdata;
    }

    public void setRpdata(RpdataBean rpdata) {
        this.rpdata = rpdata;
    }

    public static class RpdataBean {
        /**
         * count : 10
         * list : [{"billno":"12345678","billdate":"2017-08-03","storename":"门店001","customername":"张三","address":"南京市秦淮区洪武路222号","telephone":"13166669999","appointmenttime":"2017-08-20","salesdocno":"234565432","status":"0","closedstate":"0","isfull":"1","tfinalamount":"24300","paidamount":"0","totalquantity":"20","product":[{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发1111","quantity":"3","amount":"3000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发33311","quantity":"2","amount":"5000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发221","quantity":"4","amount":"4000"}]},{"billno":"12345678","billdate":"2017-08-03","storename":"门店001","customername":"李四","address":"南京市秦淮区洪武路222号","telephone":"13166669999","appointmenttime":"2017-08-20","salesdocno":"234565432","status":"1","closedstate":"0","isfull":"1","tfinalamount":"23400","paidamount":"0","totalquantity":"20","product":[{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发1111","quantity":"3","amount":"3000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发33311","quantity":"2","amount":"5000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发221","quantity":"4","amount":"4000"}]},{"billno":"12345678","billdate":"2017-08-03","storename":"门店001","customername":"王五","address":"南京市秦淮区洪武路222号","telephone":"13166669999","appointmenttime":"2017-08-20","salesdocno":"234565432","status":"2","closedstate":"0","isfull":"1","tfinalamount":"24300","paidamount":"0","totalquantity":"20","product":[{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发1111","quantity":"3","amount":"3000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发33311","quantity":"2","amount":"5000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发221","quantity":"4","amount":"4000"}]},{"billno":"12345678","billdate":"2017-08-03","storename":"门店001","customername":"张三fd","address":"南京市秦淮区洪武路222号","telephone":"13166669999","appointmenttime":"2017-08-20","salesdocno":"234565432","status":"2","closedstate":"0","isfull":"1","tfinalamount":"24300","paidamount":"0","totalquantity":"20","product":[{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发1111","quantity":"3","amount":"3000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发33311","quantity":"2","amount":"5000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发221","quantity":"4","amount":"4000"}]}]
         */

        private String count;
        private List<ListBean> list;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * billno : 12345678
             * billdate : 2017-08-03
             * storename : 门店001
             * customername : 张三
             * address : 南京市秦淮区洪武路222号
             * telephone : 13166669999
             * appointmenttime : 2017-08-20
             * salesdocno : 234565432
             * status : 0
             * closedstate : 0
             * isfull : 1
             * tfinalamount : 24300
             * paidamount : 0
             * totalquantity : 20
             * product : [{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发1111","quantity":"3","amount":"3000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发33311","quantity":"2","amount":"5000"},{"prodno":"22222111","picture":"https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg","prodname":"沙发221","quantity":"4","amount":"4000"}]
             */

            private String billno;
            private String billdate;
            private String storename;
            private String customername;
            private String address;
            private String telephone;
            private String appointmenttime;
            private String salesdocno;
            private String status;
            private String closedstate;
            private String isfull;
            private String tfinalamount;
            private String paidamount;
            private String totalquantity;
            private List<ProductBean> product;

            public String getBillno() {
                return billno;
            }

            public void setBillno(String billno) {
                this.billno = billno;
            }

            public String getBilldate() {
                return billdate;
            }

            public void setBilldate(String billdate) {
                this.billdate = billdate;
            }

            public String getStorename() {
                return storename;
            }

            public void setStorename(String storename) {
                this.storename = storename;
            }

            public String getCustomername() {
                return customername;
            }

            public void setCustomername(String customername) {
                this.customername = customername;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getAppointmenttime() {
                return appointmenttime;
            }

            public void setAppointmenttime(String appointmenttime) {
                this.appointmenttime = appointmenttime;
            }

            public String getSalesdocno() {
                return salesdocno;
            }

            public void setSalesdocno(String salesdocno) {
                this.salesdocno = salesdocno;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getClosedstate() {
                return closedstate;
            }

            public void setClosedstate(String closedstate) {
                this.closedstate = closedstate;
            }

            public String getIsfull() {
                return isfull;
            }

            public void setIsfull(String isfull) {
                this.isfull = isfull;
            }

            public String getTfinalamount() {
                return tfinalamount;
            }

            public void setTfinalamount(String tfinalamount) {
                this.tfinalamount = tfinalamount;
            }

            public String getPaidamount() {
                return paidamount;
            }

            public void setPaidamount(String paidamount) {
                this.paidamount = paidamount;
            }

            public String getTotalquantity() {
                return totalquantity;
            }

            public void setTotalquantity(String totalquantity) {
                this.totalquantity = totalquantity;
            }

            public List<ProductBean> getProduct() {
                return product;
            }

            public void setProduct(List<ProductBean> product) {
                this.product = product;
            }

            public static class ProductBean {
                /**
                 * prodno : 22222111
                 * picture : https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/TB1DqHQPFXXXXbgXpXXXXXXXXXX_!!0-item_pic.jpg_230x230.jpg
                 * prodname : 沙发1111
                 * quantity : 3
                 * amount : 3000
                 */

                private String prodno;
                private String picture;
                private String prodname;
                private String quantity;
                private String amount;

                public String getProdno() {
                    return prodno;
                }

                public void setProdno(String prodno) {
                    this.prodno = prodno;
                }

                public String getPicture() {
                    return picture;
                }

                public void setPicture(String picture) {
                    this.picture = picture;
                }

                public String getProdname() {
                    return prodname;
                }

                public void setProdname(String prodname) {
                    this.prodname = prodname;
                }

                public String getQuantity() {
                    return quantity;
                }

                public void setQuantity(String quantity) {
                    this.quantity = quantity;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }
            }
        }
    }
}
