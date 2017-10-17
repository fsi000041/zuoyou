package com.bigzone.zuoyou.sales.bean;

import java.util.List;

/**
 * Created by haohongwei on 2017/7/21.
 */

public class SalesDetailEntity {

    /**
     * status : success
     * order : {"billno":"12345678","billdate":"2017-08-03","storeno":"100","storename":"左右门店","customerno":"","customername":"","telephone":"13166669999","address":"南京市秦淮区洪武大厦","appointmenttime":"2017-09-10","deliverymethod":"送货上门","salesno":"001","salesname":"张三","salesdocno":"001","deliverydate":"2017-08-20","status":"1","auditor":"管理员","auditorname":"李四","auditortime":"2017-08-04","closedstate":"","totalamount":"23400.00","tdiscountamout":"0","sdiscountrate":"1","tfinalamount":"23400.00","memo":"这是备注","createuser":"admin","createusername":"开单人员admin","createtime":"2017-08-03","updateuser":"admin","updateusername":"开单人员admin","updatetime":"2017-08-04","product":[{"detailno":"12345678","billno":"12345678","type":"沙发","prodno":"994848837","prodname":"沙发0001","storageno":"001","storagename":"仓库001","unitno":"22","unitname":"单位22","quantity":"2","unitprice":"1000","taxno":"","taxname":"税种名称1","taxrate":"","discountrate":"1","amount":"2000","discountamount":"0","finalamount":"2000","attainfo":"皮布属性","custinfo":"标准定制属性","combinfo":"组合成分明细","cdescription":"定制说明－沙发","patchno":"44332","patchname":"沙发套枕","pretaxamount":"100","taxamount":"0","memo":"这个沙发是真皮的","createuser":"","createusername":"","createtime":"","updateuser":"","updateusername":"","updatetime":""},{"detailno":"12345678","billno":"12345678","type":"沙发","prodno":"994848837","prodname":"沙发0002","storageno":"001","storagename":"仓库001","unitno":"22","unitname":"单位22","quantity":"3","unitprice":"1500","taxno":"","taxname":"税种名称1","taxrate":"","discountrate":"1","amount":"4500","discountamount":"0","finalamount":"4500","attainfo":"皮布属性","custinfo":"标准定制属性","combinfo":"组合成分明细","cdescription":"定制说明－沙发","patchno":"44332","patchname":"沙发套枕","pretaxamount":"100","taxamount":"0","memo":"这个沙发是黑色的","createuser":"","createusername":"","createtime":"","updateuser":"","updateusername":"","updatetime":""},{"detailno":"12345678","billno":"12345678","type":"沙发","prodno":"994848837","prodname":"沙发0003","storageno":"001","storagename":"仓库001","unitno":"22","unitname":"单位22","quantity":"2","unitprice":"1000","taxno":"","taxname":"税种名称1","taxrate":"","discountrate":"1","amount":"2000","discountamount":"0","finalamount":"2000","attainfo":"皮布属性","custinfo":"标准定制属性","combinfo":"组合成分明细","cdescription":"定制说明－沙发","patchno":"44332","patchname":"沙发套枕","pretaxamount":"100","taxamount":"0","memo":"这个沙发是黄色的","createuser":"","createusername":"","createtime":"","updateuser":"","updateusername":"","updatetime":""}],"payment":[{"detailno":"","billno":"12345678","payno":"98765432","payname":"银行卡收款","paidamount":"20000","commrate":"0.001","feeamount":"20","cardno":"6228483344555554444","memo":"张三买沙发收款","createuser":"admin","createusername":"admin","createtime":"2017-09-20","updateuser":"","updateusername":"","updatetime":""}]}
     */

    private String status;
    private OrderBean order;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public static class OrderBean {
        /**
         * billno : 12345678
         * billdate : 2017-08-03
         * storeno : 100
         * storename : 左右门店
         * customerno :
         * customername :
         * telephone : 13166669999
         * address : 南京市秦淮区洪武大厦
         * appointmenttime : 2017-09-10
         * deliverymethod : 送货上门
         * salesno : 001
         * salesname : 张三
         * salesdocno : 001
         * deliverydate : 2017-08-20
         * status : 1
         * auditor : 管理员
         * auditorname : 李四
         * auditortime : 2017-08-04
         * closedstate :
         * totalamount : 23400.00
         * tdiscountamout : 0
         * sdiscountrate : 1
         * tfinalamount : 23400.00
         * memo : 这是备注
         * createuser : admin
         * createusername : 开单人员admin
         * createtime : 2017-08-03
         * updateuser : admin
         * updateusername : 开单人员admin
         * updatetime : 2017-08-04
         * product : [{"detailno":"12345678","billno":"12345678","type":"沙发","prodno":"994848837","prodname":"沙发0001","storageno":"001","storagename":"仓库001","unitno":"22","unitname":"单位22","quantity":"2","unitprice":"1000","taxno":"","taxname":"税种名称1","taxrate":"","discountrate":"1","amount":"2000","discountamount":"0","finalamount":"2000","attainfo":"皮布属性","custinfo":"标准定制属性","combinfo":"组合成分明细","cdescription":"定制说明－沙发","patchno":"44332","patchname":"沙发套枕","pretaxamount":"100","taxamount":"0","memo":"这个沙发是真皮的","createuser":"","createusername":"","createtime":"","updateuser":"","updateusername":"","updatetime":""},{"detailno":"12345678","billno":"12345678","type":"沙发","prodno":"994848837","prodname":"沙发0002","storageno":"001","storagename":"仓库001","unitno":"22","unitname":"单位22","quantity":"3","unitprice":"1500","taxno":"","taxname":"税种名称1","taxrate":"","discountrate":"1","amount":"4500","discountamount":"0","finalamount":"4500","attainfo":"皮布属性","custinfo":"标准定制属性","combinfo":"组合成分明细","cdescription":"定制说明－沙发","patchno":"44332","patchname":"沙发套枕","pretaxamount":"100","taxamount":"0","memo":"这个沙发是黑色的","createuser":"","createusername":"","createtime":"","updateuser":"","updateusername":"","updatetime":""},{"detailno":"12345678","billno":"12345678","type":"沙发","prodno":"994848837","prodname":"沙发0003","storageno":"001","storagename":"仓库001","unitno":"22","unitname":"单位22","quantity":"2","unitprice":"1000","taxno":"","taxname":"税种名称1","taxrate":"","discountrate":"1","amount":"2000","discountamount":"0","finalamount":"2000","attainfo":"皮布属性","custinfo":"标准定制属性","combinfo":"组合成分明细","cdescription":"定制说明－沙发","patchno":"44332","patchname":"沙发套枕","pretaxamount":"100","taxamount":"0","memo":"这个沙发是黄色的","createuser":"","createusername":"","createtime":"","updateuser":"","updateusername":"","updatetime":""}]
         * payment : [{"detailno":"","billno":"12345678","payno":"98765432","payname":"银行卡收款","paidamount":"20000","commrate":"0.001","feeamount":"20","cardno":"6228483344555554444","memo":"张三买沙发收款","createuser":"admin","createusername":"admin","createtime":"2017-09-20","updateuser":"","updateusername":"","updatetime":""}]
         */

        private String billno;
        private String billdate;
        private String storeno;
        private String storename;
        private String customerno;
        private String customername;
        private String telephone;
        private String address;
        private String appointmenttime;
        private String deliverymethod;
        private String salesno;
        private String salesname;
        private String salesdocno;
        private String deliverydate;
        private String status;
        private String auditor;
        private String auditorname;
        private String auditortime;
        private String closedstate;
        private String totalamount;
        private String tdiscountamout;
        private String sdiscountrate;
        private String tfinalamount;
        private String memo;
        private String createuser;
        private String createusername;
        private String createtime;
        private String updateuser;
        private String updateusername;
        private String updatetime;
        private List<ProductBean> product;
        private List<PaymentBean> payment;

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

        public String getStoreno() {
            return storeno;
        }

        public void setStoreno(String storeno) {
            this.storeno = storeno;
        }

        public String getStorename() {
            return storename;
        }

        public void setStorename(String storename) {
            this.storename = storename;
        }

        public String getCustomerno() {
            return customerno;
        }

        public void setCustomerno(String customerno) {
            this.customerno = customerno;
        }

        public String getCustomername() {
            return customername;
        }

        public void setCustomername(String customername) {
            this.customername = customername;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAppointmenttime() {
            return appointmenttime;
        }

        public void setAppointmenttime(String appointmenttime) {
            this.appointmenttime = appointmenttime;
        }

        public String getDeliverymethod() {
            return deliverymethod;
        }

        public void setDeliverymethod(String deliverymethod) {
            this.deliverymethod = deliverymethod;
        }

        public String getSalesno() {
            return salesno;
        }

        public void setSalesno(String salesno) {
            this.salesno = salesno;
        }

        public String getSalesname() {
            return salesname;
        }

        public void setSalesname(String salesname) {
            this.salesname = salesname;
        }

        public String getSalesdocno() {
            return salesdocno;
        }

        public void setSalesdocno(String salesdocno) {
            this.salesdocno = salesdocno;
        }

        public String getDeliverydate() {
            return deliverydate;
        }

        public void setDeliverydate(String deliverydate) {
            this.deliverydate = deliverydate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAuditor() {
            return auditor;
        }

        public void setAuditor(String auditor) {
            this.auditor = auditor;
        }

        public String getAuditorname() {
            return auditorname;
        }

        public void setAuditorname(String auditorname) {
            this.auditorname = auditorname;
        }

        public String getAuditortime() {
            return auditortime;
        }

        public void setAuditortime(String auditortime) {
            this.auditortime = auditortime;
        }

        public String getClosedstate() {
            return closedstate;
        }

        public void setClosedstate(String closedstate) {
            this.closedstate = closedstate;
        }

        public String getTotalamount() {
            return totalamount;
        }

        public void setTotalamount(String totalamount) {
            this.totalamount = totalamount;
        }

        public String getTdiscountamout() {
            return tdiscountamout;
        }

        public void setTdiscountamout(String tdiscountamout) {
            this.tdiscountamout = tdiscountamout;
        }

        public String getSdiscountrate() {
            return sdiscountrate;
        }

        public void setSdiscountrate(String sdiscountrate) {
            this.sdiscountrate = sdiscountrate;
        }

        public String getTfinalamount() {
            return tfinalamount;
        }

        public void setTfinalamount(String tfinalamount) {
            this.tfinalamount = tfinalamount;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getCreateuser() {
            return createuser;
        }

        public void setCreateuser(String createuser) {
            this.createuser = createuser;
        }

        public String getCreateusername() {
            return createusername;
        }

        public void setCreateusername(String createusername) {
            this.createusername = createusername;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getUpdateuser() {
            return updateuser;
        }

        public void setUpdateuser(String updateuser) {
            this.updateuser = updateuser;
        }

        public String getUpdateusername() {
            return updateusername;
        }

        public void setUpdateusername(String updateusername) {
            this.updateusername = updateusername;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public List<ProductBean> getProduct() {
            return product;
        }

        public void setProduct(List<ProductBean> product) {
            this.product = product;
        }

        public List<PaymentBean> getPayment() {
            return payment;
        }

        public void setPayment(List<PaymentBean> payment) {
            this.payment = payment;
        }

        public static class ProductBean {
            /**
             * detailno : 12345678
             * billno : 12345678
             * type : 沙发
             * prodno : 994848837
             * prodname : 沙发0001
             * storageno : 001
             * storagename : 仓库001
             * unitno : 22
             * unitname : 单位22
             * quantity : 2
             * unitprice : 1000
             * taxno :
             * taxname : 税种名称1
             * taxrate :
             * discountrate : 1
             * amount : 2000
             * discountamount : 0
             * finalamount : 2000
             * attainfo : 皮布属性
             * custinfo : 标准定制属性
             * combinfo : 组合成分明细
             * cdescription : 定制说明－沙发
             * patchno : 44332
             * patchname : 沙发套枕
             * pretaxamount : 100
             * taxamount : 0
             * memo : 这个沙发是真皮的
             * createuser :
             * createusername :
             * createtime :
             * updateuser :
             * updateusername :
             * updatetime :
             */

            private String detailno;
            private String billno;
            private String type;
            private String prodno;
            private String prodname;
            private String storageno;
            private String storagename;
            private String unitno;
            private String unitname;
            private String quantity;
            private String unitprice;
            private String taxno;
            private String taxname;
            private String taxrate;
            private String discountrate;
            private String amount;
            private String discountamount;
            private String finalamount;
            private String attainfo;
            private String custinfo;
            private String combinfo;
            private String cdescription;
            private String patchno;
            private String patchname;
            private String pretaxamount;
            private String taxamount;
            private String memo;
            private String createuser;
            private String createusername;
            private String createtime;
            private String updateuser;
            private String updateusername;
            private String updatetime;

            public String getDetailno() {
                return detailno;
            }

            public void setDetailno(String detailno) {
                this.detailno = detailno;
            }

            public String getBillno() {
                return billno;
            }

            public void setBillno(String billno) {
                this.billno = billno;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getProdno() {
                return prodno;
            }

            public void setProdno(String prodno) {
                this.prodno = prodno;
            }

            public String getProdname() {
                return prodname;
            }

            public void setProdname(String prodname) {
                this.prodname = prodname;
            }

            public String getStorageno() {
                return storageno;
            }

            public void setStorageno(String storageno) {
                this.storageno = storageno;
            }

            public String getStoragename() {
                return storagename;
            }

            public void setStoragename(String storagename) {
                this.storagename = storagename;
            }

            public String getUnitno() {
                return unitno;
            }

            public void setUnitno(String unitno) {
                this.unitno = unitno;
            }

            public String getUnitname() {
                return unitname;
            }

            public void setUnitname(String unitname) {
                this.unitname = unitname;
            }

            public String getQuantity() {
                return quantity;
            }

            public void setQuantity(String quantity) {
                this.quantity = quantity;
            }

            public String getUnitprice() {
                return unitprice;
            }

            public void setUnitprice(String unitprice) {
                this.unitprice = unitprice;
            }

            public String getTaxno() {
                return taxno;
            }

            public void setTaxno(String taxno) {
                this.taxno = taxno;
            }

            public String getTaxname() {
                return taxname;
            }

            public void setTaxname(String taxname) {
                this.taxname = taxname;
            }

            public String getTaxrate() {
                return taxrate;
            }

            public void setTaxrate(String taxrate) {
                this.taxrate = taxrate;
            }

            public String getDiscountrate() {
                return discountrate;
            }

            public void setDiscountrate(String discountrate) {
                this.discountrate = discountrate;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getDiscountamount() {
                return discountamount;
            }

            public void setDiscountamount(String discountamount) {
                this.discountamount = discountamount;
            }

            public String getFinalamount() {
                return finalamount;
            }

            public void setFinalamount(String finalamount) {
                this.finalamount = finalamount;
            }

            public String getAttainfo() {
                return attainfo;
            }

            public void setAttainfo(String attainfo) {
                this.attainfo = attainfo;
            }

            public String getCustinfo() {
                return custinfo;
            }

            public void setCustinfo(String custinfo) {
                this.custinfo = custinfo;
            }

            public String getCombinfo() {
                return combinfo;
            }

            public void setCombinfo(String combinfo) {
                this.combinfo = combinfo;
            }

            public String getCdescription() {
                return cdescription;
            }

            public void setCdescription(String cdescription) {
                this.cdescription = cdescription;
            }

            public String getPatchno() {
                return patchno;
            }

            public void setPatchno(String patchno) {
                this.patchno = patchno;
            }

            public String getPatchname() {
                return patchname;
            }

            public void setPatchname(String patchname) {
                this.patchname = patchname;
            }

            public String getPretaxamount() {
                return pretaxamount;
            }

            public void setPretaxamount(String pretaxamount) {
                this.pretaxamount = pretaxamount;
            }

            public String getTaxamount() {
                return taxamount;
            }

            public void setTaxamount(String taxamount) {
                this.taxamount = taxamount;
            }

            public String getMemo() {
                return memo;
            }

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public String getCreateuser() {
                return createuser;
            }

            public void setCreateuser(String createuser) {
                this.createuser = createuser;
            }

            public String getCreateusername() {
                return createusername;
            }

            public void setCreateusername(String createusername) {
                this.createusername = createusername;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getUpdateuser() {
                return updateuser;
            }

            public void setUpdateuser(String updateuser) {
                this.updateuser = updateuser;
            }

            public String getUpdateusername() {
                return updateusername;
            }

            public void setUpdateusername(String updateusername) {
                this.updateusername = updateusername;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }

        public static class PaymentBean {
            /**
             * detailno :
             * billno : 12345678
             * payno : 98765432
             * payname : 银行卡收款
             * paidamount : 20000
             * commrate : 0.001
             * feeamount : 20
             * cardno : 6228483344555554444
             * memo : 张三买沙发收款
             * createuser : admin
             * createusername : admin
             * createtime : 2017-09-20
             * updateuser :
             * updateusername :
             * updatetime :
             */

            private String detailno;
            private String billno;
            private String payno;
            private String payname;
            private String paidamount;
            private String commrate;
            private String feeamount;
            private String cardno;
            private String memo;
            private String createuser;
            private String createusername;
            private String createtime;
            private String updateuser;
            private String updateusername;
            private String updatetime;

            public String getDetailno() {
                return detailno;
            }

            public void setDetailno(String detailno) {
                this.detailno = detailno;
            }

            public String getBillno() {
                return billno;
            }

            public void setBillno(String billno) {
                this.billno = billno;
            }

            public String getPayno() {
                return payno;
            }

            public void setPayno(String payno) {
                this.payno = payno;
            }

            public String getPayname() {
                return payname;
            }

            public void setPayname(String payname) {
                this.payname = payname;
            }

            public String getPaidamount() {
                return paidamount;
            }

            public void setPaidamount(String paidamount) {
                this.paidamount = paidamount;
            }

            public String getCommrate() {
                return commrate;
            }

            public void setCommrate(String commrate) {
                this.commrate = commrate;
            }

            public String getFeeamount() {
                return feeamount;
            }

            public void setFeeamount(String feeamount) {
                this.feeamount = feeamount;
            }

            public String getCardno() {
                return cardno;
            }

            public void setCardno(String cardno) {
                this.cardno = cardno;
            }

            public String getMemo() {
                return memo;
            }

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public String getCreateuser() {
                return createuser;
            }

            public void setCreateuser(String createuser) {
                this.createuser = createuser;
            }

            public String getCreateusername() {
                return createusername;
            }

            public void setCreateusername(String createusername) {
                this.createusername = createusername;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getUpdateuser() {
                return updateuser;
            }

            public void setUpdateuser(String updateuser) {
                this.updateuser = updateuser;
            }

            public String getUpdateusername() {
                return updateusername;
            }

            public void setUpdateusername(String updateusername) {
                this.updateusername = updateusername;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
