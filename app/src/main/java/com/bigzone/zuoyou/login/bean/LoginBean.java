package com.bigzone.zuoyou.login.bean;

/**
 * 作者：Nick CY on 2017/10/9 15:40
 * 邮箱：fsi000044@163.com
 */

public class LoginBean {

    /**
     * rpdata : {"staffno":"0101","dealerid":"zytest","storename":"优家家具","staffname":"张默","dealername":"广东省深圳市左右家么有限公司","longintime":1507533888245,"loginstorecode":"005","usercode":"1","sessiontoken":"13839D19C9F8FD43A94DACB56ADB7A30","limitstore":"0","usertype":"1","useracc":"admin","deptno":"01","storecode":"005","deptname":"销售部","lasttime":1507533888245,"updateusername":"csadmin","sysPath":"/v1/api","phone":"15367043240","loginstorename":"优家家具","updateuseracc":"csadmin","updatetime":"2017-09-18 16:51:39","username":"张默","status":"Y","dataprivs":{}}
     * status : success
     */

    private RpdataBean rpdata;
    private String status;

    public RpdataBean getRpdata() {
        return rpdata;
    }

    public void setRpdata(RpdataBean rpdata) {
        this.rpdata = rpdata;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class RpdataBean {
        /**
         * staffno : 0101
         * dealerid : zytest
         * storename : 优家家具
         * staffname : 张默
         * dealername : 广东省深圳市左右家么有限公司
         * longintime : 1507533888245
         * loginstorecode : 005
         * usercode : 1
         * sessiontoken : 13839D19C9F8FD43A94DACB56ADB7A30
         * limitstore : 0
         * usertype : 1
         * useracc : admin
         * deptno : 01
         * storecode : 005
         * deptname : 销售部
         * lasttime : 1507533888245
         * updateusername : csadmin
         * sysPath : /v1/api
         * phone : 15367043240
         * loginstorename : 优家家具
         * updateuseracc : csadmin
         * updatetime : 2017-09-18 16:51:39
         * username : 张默
         * status : Y
         * dataprivs : {}
         */

        private String staffno;
        private String dealerid;
        private String storename;
        private String staffname;
        private String dealername;
        private long longintime;
        private String loginstorecode;
        private String usercode;
        private String sessiontoken;
        private String limitstore;
        private String usertype;
        private String useracc;
        private String deptno;
        private String storecode;
        private String deptname;
        private long lasttime;
        private String updateusername;
        private String sysPath;
        private String phone;
        private String loginstorename;
        private String updateuseracc;
        private String updatetime;
        private String username;
        private String status;
        private DataprivsBean dataprivs;

        public String getStaffno() {
            return staffno;
        }

        public void setStaffno(String staffno) {
            this.staffno = staffno;
        }

        public String getDealerid() {
            return dealerid;
        }

        public void setDealerid(String dealerid) {
            this.dealerid = dealerid;
        }

        public String getStorename() {
            return storename;
        }

        public void setStorename(String storename) {
            this.storename = storename;
        }

        public String getStaffname() {
            return staffname;
        }

        public void setStaffname(String staffname) {
            this.staffname = staffname;
        }

        public String getDealername() {
            return dealername;
        }

        public void setDealername(String dealername) {
            this.dealername = dealername;
        }

        public long getLongintime() {
            return longintime;
        }

        public void setLongintime(long longintime) {
            this.longintime = longintime;
        }

        public String getLoginstorecode() {
            return loginstorecode;
        }

        public void setLoginstorecode(String loginstorecode) {
            this.loginstorecode = loginstorecode;
        }

        public String getUsercode() {
            return usercode;
        }

        public void setUsercode(String usercode) {
            this.usercode = usercode;
        }

        public String getSessiontoken() {
            return sessiontoken;
        }

        public void setSessiontoken(String sessiontoken) {
            this.sessiontoken = sessiontoken;
        }

        public String getLimitstore() {
            return limitstore;
        }

        public void setLimitstore(String limitstore) {
            this.limitstore = limitstore;
        }

        public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }

        public String getUseracc() {
            return useracc;
        }

        public void setUseracc(String useracc) {
            this.useracc = useracc;
        }

        public String getDeptno() {
            return deptno;
        }

        public void setDeptno(String deptno) {
            this.deptno = deptno;
        }

        public String getStorecode() {
            return storecode;
        }

        public void setStorecode(String storecode) {
            this.storecode = storecode;
        }

        public String getDeptname() {
            return deptname;
        }

        public void setDeptname(String deptname) {
            this.deptname = deptname;
        }

        public long getLasttime() {
            return lasttime;
        }

        public void setLasttime(long lasttime) {
            this.lasttime = lasttime;
        }

        public String getUpdateusername() {
            return updateusername;
        }

        public void setUpdateusername(String updateusername) {
            this.updateusername = updateusername;
        }

        public String getSysPath() {
            return sysPath;
        }

        public void setSysPath(String sysPath) {
            this.sysPath = sysPath;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getLoginstorename() {
            return loginstorename;
        }

        public void setLoginstorename(String loginstorename) {
            this.loginstorename = loginstorename;
        }

        public String getUpdateuseracc() {
            return updateuseracc;
        }

        public void setUpdateuseracc(String updateuseracc) {
            this.updateuseracc = updateuseracc;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public DataprivsBean getDataprivs() {
            return dataprivs;
        }

        public void setDataprivs(DataprivsBean dataprivs) {
            this.dataprivs = dataprivs;
        }

        public static class DataprivsBean {


        }

        @Override
        public String toString() {
            return "RpdataBean{" +
                    "staffno='" + staffno + '\'' +
                    ", dealerid='" + dealerid + '\'' +
                    ", storename='" + storename + '\'' +
                    ", staffname='" + staffname + '\'' +
                    ", dealername='" + dealername + '\'' +
                    ", longintime=" + longintime +
                    ", loginstorecode='" + loginstorecode + '\'' +
                    ", usercode='" + usercode + '\'' +
                    ", sessiontoken='" + sessiontoken + '\'' +
                    ", limitstore='" + limitstore + '\'' +
                    ", usertype='" + usertype + '\'' +
                    ", useracc='" + useracc + '\'' +
                    ", deptno='" + deptno + '\'' +
                    ", storecode='" + storecode + '\'' +
                    ", deptname='" + deptname + '\'' +
                    ", lasttime=" + lasttime +
                    ", updateusername='" + updateusername + '\'' +
                    ", sysPath='" + sysPath + '\'' +
                    ", phone='" + phone + '\'' +
                    ", loginstorename='" + loginstorename + '\'' +
                    ", updateuseracc='" + updateuseracc + '\'' +
                    ", updatetime='" + updatetime + '\'' +
                    ", username='" + username + '\'' +
                    ", status='" + status + '\'' +
                    ", dataprivs=" + dataprivs +
                    '}';
        }
    }

}
