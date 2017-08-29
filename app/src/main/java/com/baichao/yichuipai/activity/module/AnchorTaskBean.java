package com.baichao.yichuipai.activity.module;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */

public class AnchorTaskBean {

    /**
     * code : 1
     * msg : 操作成功！
     * data : {"tomorrowTaskList":[{"auctionId":1,"taskDesc":"任务描述","finishTime":1503631765000,"taskName":"这是个任务","id":2,"beginTime":1503630900000,"taskStatus":0}],"todayTaskList":[{"auctionId":1,"taskDesc":"任务描述","finishTime":null,"taskName":"这是个任务","id":1,"beginTime":1503504000000,"taskStatus":0}]}
     */

    private String code;
    private String msg;
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
        private List<TomorrowTaskListBean> tomorrowTaskList;
        private List<TodayTaskListBean> todayTaskList;

        public List<TomorrowTaskListBean> getTomorrowTaskList() {
            return tomorrowTaskList;
        }

        public void setTomorrowTaskList(List<TomorrowTaskListBean> tomorrowTaskList) {
            this.tomorrowTaskList = tomorrowTaskList;
        }

        public List<TodayTaskListBean> getTodayTaskList() {
            return todayTaskList;
        }

        public void setTodayTaskList(List<TodayTaskListBean> todayTaskList) {
            this.todayTaskList = todayTaskList;
        }

        public static class TomorrowTaskListBean {
            /**
             * auctionId : 1
             * taskDesc : 任务描述
             * finishTime : 1503631765000
             * taskName : 这是个任务
             * id : 2
             * beginTime : 1503630900000
             * taskStatus : 0
             */

            private int auctionId;
            private String taskDesc;
            private long finishTime;
            private String taskName;
            private int id;
            private long beginTime;
            private int taskStatus;

            public int getAuctionId() {
                return auctionId;
            }

            public void setAuctionId(int auctionId) {
                this.auctionId = auctionId;
            }

            public String getTaskDesc() {
                return taskDesc;
            }

            public void setTaskDesc(String taskDesc) {
                this.taskDesc = taskDesc;
            }

            public long getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(long finishTime) {
                this.finishTime = finishTime;
            }

            public String getTaskName() {
                return taskName;
            }

            public void setTaskName(String taskName) {
                this.taskName = taskName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getBeginTime() {
                return beginTime;
            }

            public void setBeginTime(long beginTime) {
                this.beginTime = beginTime;
            }

            public int getTaskStatus() {
                return taskStatus;
            }

            public void setTaskStatus(int taskStatus) {
                this.taskStatus = taskStatus;
            }
        }

        public static class TodayTaskListBean {
            /**
             * auctionId : 1
             * taskDesc : 任务描述
             * finishTime : null
             * taskName : 这是个任务
             * id : 1
             * beginTime : 1503504000000
             * taskStatus : 0
             */

            private int auctionId;
            private String taskDesc;
            private Object finishTime;
            private String taskName;
            private int id;
            private long beginTime;
            private int taskStatus;

            public int getAuctionId() {
                return auctionId;
            }

            public void setAuctionId(int auctionId) {
                this.auctionId = auctionId;
            }

            public String getTaskDesc() {
                return taskDesc;
            }

            public void setTaskDesc(String taskDesc) {
                this.taskDesc = taskDesc;
            }

            public Object getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(Object finishTime) {
                this.finishTime = finishTime;
            }

            public String getTaskName() {
                return taskName;
            }

            public void setTaskName(String taskName) {
                this.taskName = taskName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getBeginTime() {
                return beginTime;
            }

            public void setBeginTime(long beginTime) {
                this.beginTime = beginTime;
            }

            public int getTaskStatus() {
                return taskStatus;
            }

            public void setTaskStatus(int taskStatus) {
                this.taskStatus = taskStatus;
            }
        }
    }
}
