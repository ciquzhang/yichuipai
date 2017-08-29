package com.baichao.yichuipai.activity.module;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */

public class AnchorPassTaskBean {

    /**
     * code : 1
     * msg : 操作成功！
     * data : {"num":1,"rowCount":3,"startRow":0,"pageSize":10,"navCount":1,"prev":1,"next":1,"first":1,"last":1,"begin":1,"end":1,"navNum":5,"parameter":null,"pageData":[{"auctionId":1,"taskDesc":"任务描述","finishTime":null,"taskType":0,"taskName":"这是个任务","id":1,"beginTime":1503504000000,"taskStatus":0},{"auctionId":1,"taskDesc":"任务描述","finishTime":null,"taskType":0,"taskName":"这是往日任务","id":3,"beginTime":1503480337000,"taskStatus":0},{"auctionId":8898,"taskDesc":"看房任务-08月19日-14:00-星河庄园4栋1单元203","finishTime":null,"taskType":1,"taskName":"看房任务-08月19日-14:00-星河庄园4栋1单元203","id":4,"beginTime":1503547200000,"taskStatus":0}]}
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
        /**
         * num : 1
         * rowCount : 3
         * startRow : 0
         * pageSize : 10
         * navCount : 1
         * prev : 1
         * next : 1
         * first : 1
         * last : 1
         * begin : 1
         * end : 1
         * navNum : 5
         * parameter : null
         * pageData : [{"auctionId":1,"taskDesc":"任务描述","finishTime":null,"taskType":0,"taskName":"这是个任务","id":1,"beginTime":1503504000000,"taskStatus":0},{"auctionId":1,"taskDesc":"任务描述","finishTime":null,"taskType":0,"taskName":"这是往日任务","id":3,"beginTime":1503480337000,"taskStatus":0},{"auctionId":8898,"taskDesc":"看房任务-08月19日-14:00-星河庄园4栋1单元203","finishTime":null,"taskType":1,"taskName":"看房任务-08月19日-14:00-星河庄园4栋1单元203","id":4,"beginTime":1503547200000,"taskStatus":0}]
         */

        private int num;
        private int rowCount;
        private int startRow;
        private int pageSize;
        private int navCount;
        private int prev;
        private int next;
        private int first;
        private int last;
        private int begin;
        private int end;
        private int navNum;
        private Object parameter;
        private List<PageDataBean> pageData;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getRowCount() {
            return rowCount;
        }

        public void setRowCount(int rowCount) {
            this.rowCount = rowCount;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getNavCount() {
            return navCount;
        }

        public void setNavCount(int navCount) {
            this.navCount = navCount;
        }

        public int getPrev() {
            return prev;
        }

        public void setPrev(int prev) {
            this.prev = prev;
        }

        public int getNext() {
            return next;
        }

        public void setNext(int next) {
            this.next = next;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getLast() {
            return last;
        }

        public void setLast(int last) {
            this.last = last;
        }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getNavNum() {
            return navNum;
        }

        public void setNavNum(int navNum) {
            this.navNum = navNum;
        }

        public Object getParameter() {
            return parameter;
        }

        public void setParameter(Object parameter) {
            this.parameter = parameter;
        }

        public List<PageDataBean> getPageData() {
            return pageData;
        }

        public void setPageData(List<PageDataBean> pageData) {
            this.pageData = pageData;
        }

        public static class PageDataBean {
            /**
             * auctionId : 1
             * taskDesc : 任务描述
             * finishTime : null
             * taskType : 0
             * taskName : 这是个任务
             * id : 1
             * beginTime : 1503504000000
             * taskStatus : 0
             */

            private int auctionId;
            private String taskDesc;
            private Object finishTime;
            private int taskType;
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

            public int getTaskType() {
                return taskType;
            }

            public void setTaskType(int taskType) {
                this.taskType = taskType;
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
