package com.baichao.yichuipai.activity.module;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public class MeetingListBean {

    /**
     * code : 1
     * msg : 操作成功！
     * data : [{"startTime":"2017-07-05 16:51:00.0","title":"云南映象-一期","startPrice":1000000,"pv":156,"imgUrl":"/2017/06/28/2017062811562354.jpg","auctionId":8888,"houseId":8888},{"startTime":"2017-07-05 16:51:00.0","title":"云南映象-花好月圆","startPrice":1000000,"pv":21,"imgUrl":"/2017/06/28/2017062811562354.jpg","auctionId":888,"houseId":888}]
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
         * startTime : 2017-07-05 16:51:00.0
         * title : 云南映象-一期
         * startPrice : 1000000
         * pv : 156
         * imgUrl : /2017/06/28/2017062811562354.jpg
         * auctionId : 8888
         * houseId : 8888
         */

        private String startTime;
        private String title;
        private int startPrice;
        private int pv;
        private String imgUrl;
        private int auctionId;
        private int houseId;

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getStartPrice() {
            return startPrice;
        }

        public void setStartPrice(int startPrice) {
            this.startPrice = startPrice;
        }

        public int getPv() {
            return pv;
        }

        public void setPv(int pv) {
            this.pv = pv;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getAuctionId() {
            return auctionId;
        }

        public void setAuctionId(int auctionId) {
            this.auctionId = auctionId;
        }

        public int getHouseId() {
            return houseId;
        }

        public void setHouseId(int houseId) {
            this.houseId = houseId;
        }
    }
}
