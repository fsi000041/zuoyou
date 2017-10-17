package com.bigzone.zuoyou.billing.bean;

/**
 * Created by sszz on 2017/10/17.
 */

public class TextBean {

    /**
     * message : {"code":12,"info":"浼氳瘽浠ょ墝澶辨晥"}
     * status : failure
     */

    private MessageBean message;
    private String status;

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class MessageBean {
        /**
         * code : 12
         * info : 浼氳瘽浠ょ墝澶辨晥
         */

        private int code;
        private String info;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
