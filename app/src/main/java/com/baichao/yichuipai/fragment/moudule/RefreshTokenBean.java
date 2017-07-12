package com.baichao.yichuipai.fragment.moudule;

/**
 * Created by pll on 2017/6/5.
 */

public class RefreshTokenBean {

    /**
     * code : 1
     * msg : 刷新token成功
     * data : {"access_token":"3ac02885-2df0-47a4-bc8a-810a86ef0a66","expire_time":"1496317934"}
     */

    private String code;
    private String msg;
    /**
     * access_token : 3ac02885-2df0-47a4-bc8a-810a86ef0a66
     * expire_time : 1496317934
     */

    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String access_token;
        private String expire_time;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getExpire_time() {
            return expire_time;
        }

        public void setExpire_time(String expire_time) {
            this.expire_time = expire_time;
        }
    }
}
