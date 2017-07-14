package com.baichao.yichuipai.fragment.moudule;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */

public class AuthStatusBean {

    /**
     * code : 1
     * msg : 请求成功
     * data : [{"authCompanyStatus":"0","authStatusMsg":"未认证"},{"authPersonStatus":"1","authStatusMsg":"已认证"}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * authCompanyStatus : 0
         * authStatusMsg : 未认证
         * authPersonStatus : 1
         */

        private String authCompanyStatus;
        private String authStatusMsg;
        private String authPersonStatus;

        public String getAuthCompanyStatus() {
            return authCompanyStatus;
        }

        public void setAuthCompanyStatus(String authCompanyStatus) {
            this.authCompanyStatus = authCompanyStatus;
        }

        public String getAuthStatusMsg() {
            return authStatusMsg;
        }

        public void setAuthStatusMsg(String authStatusMsg) {
            this.authStatusMsg = authStatusMsg;
        }

        public String getAuthPersonStatus() {
            return authPersonStatus;
        }

        public void setAuthPersonStatus(String authPersonStatus) {
            this.authPersonStatus = authPersonStatus;
        }
    }
}
