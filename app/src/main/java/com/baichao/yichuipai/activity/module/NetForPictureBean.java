package com.baichao.yichuipai.activity.module;

/**
 * Created by pll on 2017/5/12.
 */

public class NetForPictureBean {

    /**
     * code : 1
     * data : {"hand_idcard":"/2017/06/05/20170605150517hand_idcard.png","idcard_back":"/2017/06/05/20170605150517idcard_back.png","idcard_front":"/2017/06/05/20170605150517idcard_front.png"}
     * msg : 上传成功
     */

    private String code;
    /**
     * hand_idcard : /2017/06/05/20170605150517hand_idcard.png
     * idcard_back : /2017/06/05/20170605150517idcard_back.png
     * idcard_front : /2017/06/05/20170605150517idcard_front.png
     */

    private DataBean data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        private String hand_idcard;
        private String idcard_back;
        private String idcard_front;
        private String bussiness_licence;

        public String getBussiness_licence() {
            return bussiness_licence;
        }

        public void setBussiness_licence(String bussiness_licence) {
            this.bussiness_licence = bussiness_licence;
        }

        public String getHand_idcard() {
            return hand_idcard;
        }

        public void setHand_idcard(String hand_idcard) {
            this.hand_idcard = hand_idcard;
        }

        public String getIdcard_back() {
            return idcard_back;
        }

        public void setIdcard_back(String idcard_back) {
            this.idcard_back = idcard_back;
        }

        public String getIdcard_front() {
            return idcard_front;
        }

        public void setIdcard_front(String idcard_front) {
            this.idcard_front = idcard_front;
        }
    }
}
