package com.baichao.yichuipai.activity.module;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public class DepositBean {

    /**
     * code : 1
     * msg : 操作成功！
     * data : [{"id":23,"userId":30,"amount":20000,"status":1,"count":0,"createTime":1499324460000,"orgUserId":null,"refundDesc":"","refundStatus":0,"refundTime":null,"depositStatus":0,"regionId":null,"thawTime":1499400782000}]
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
         * id : 23
         * userId : 30
         * amount : 20000
         * status : 1
         * count : 0
         * createTime : 1499324460000
         * orgUserId : null
         * refundDesc :
         * refundStatus : 0
         * refundTime : null
         * depositStatus : 0
         * regionId : null
         * thawTime : 1499400782000
         */

        private int id;
        private int userId;
        private int amount;
        private int status;
        private int count;
        private long createTime;
        private Object orgUserId;
        private String refundDesc;
        private int refundStatus;
        private Object refundTime;
        private int depositStatus;
        private Object regionId;
        private Long thawTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public Object getOrgUserId() {
            return orgUserId;
        }

        public void setOrgUserId(Object orgUserId) {
            this.orgUserId = orgUserId;
        }

        public String getRefundDesc() {
            return refundDesc;
        }

        public void setRefundDesc(String refundDesc) {
            this.refundDesc = refundDesc;
        }

        public int getRefundStatus() {
            return refundStatus;
        }

        public void setRefundStatus(int refundStatus) {
            this.refundStatus = refundStatus;
        }

        public Object getRefundTime() {
            return refundTime;
        }

        public void setRefundTime(Object refundTime) {
            this.refundTime = refundTime;
        }

        public int getDepositStatus() {
            return depositStatus;
        }

        public void setDepositStatus(int depositStatus) {
            this.depositStatus = depositStatus;
        }

        public Object getRegionId() {
            return regionId;
        }

        public void setRegionId(Object regionId) {
            this.regionId = regionId;
        }

        public Long getThawTime() {
            return thawTime;
        }

        public void setThawTime(Long thawTime) {
            this.thawTime = thawTime;
        }
    }
}
