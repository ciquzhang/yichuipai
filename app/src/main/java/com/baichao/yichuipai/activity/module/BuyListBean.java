package com.baichao.yichuipai.activity.module;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public class BuyListBean {

    /**
     * code : 1
     * msg : 操作成功！
     * data : {"num":1,"rowCount":17,"startRow":0,"pageSize":10,"navCount":2,"prev":1,"next":2,"first":1,"last":2,"begin":1,"end":2,"navNum":5,"parameter":null,"pageData":[{"id":82,"price":1250000,"bidTime":1499694737000,"bidStatus":1,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":81,"price":1230000,"bidTime":1499694601000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":80,"price":1220000,"bidTime":1499694593000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":79,"price":1210000,"bidTime":1499694547000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":78,"price":1200000,"bidTime":1499694484000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":77,"price":1180000,"bidTime":1499694460000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":76,"price":1170000,"bidTime":1499694458000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":75,"price":1160000,"bidTime":1499694373000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":74,"price":1150000,"bidTime":1499694369000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":73,"price":1140000,"bidTime":1499693684000,"bidStatus":0,"status":1,"userId":1,"auctionId":8889,"bidNo":"A3b21555"}]}
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
         * rowCount : 17
         * startRow : 0
         * pageSize : 10
         * navCount : 2
         * prev : 1
         * next : 2
         * first : 1
         * last : 2
         * begin : 1
         * end : 2
         * navNum : 5
         * parameter : null
         * pageData : [{"id":82,"price":1250000,"bidTime":1499694737000,"bidStatus":1,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":81,"price":1230000,"bidTime":1499694601000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":80,"price":1220000,"bidTime":1499694593000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":79,"price":1210000,"bidTime":1499694547000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":78,"price":1200000,"bidTime":1499694484000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":77,"price":1180000,"bidTime":1499694460000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":76,"price":1170000,"bidTime":1499694458000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":75,"price":1160000,"bidTime":1499694373000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":74,"price":1150000,"bidTime":1499694369000,"bidStatus":0,"status":1,"userId":30,"auctionId":8889,"bidNo":"A3b21556"},{"id":73,"price":1140000,"bidTime":1499693684000,"bidStatus":0,"status":1,"userId":1,"auctionId":8889,"bidNo":"A3b21555"}]
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
             * id : 82
             * price : 1250000
             * bidTime : 1499694737000
             * bidStatus : 1
             * status : 1
             * userId : 30
             * auctionId : 8889
             * bidNo : A3b21556
             */

            private int id;
            private int price;
            private long bidTime;
            private int bidStatus;
            private int status;
            private int userId;
            private int auctionId;
            private String bidNo;
            private int position;

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public long getBidTime() {
                return bidTime;
            }

            public void setBidTime(long bidTime) {
                this.bidTime = bidTime;
            }

            public int getBidStatus() {
                return bidStatus;
            }

            public void setBidStatus(int bidStatus) {
                this.bidStatus = bidStatus;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getAuctionId() {
                return auctionId;
            }

            public void setAuctionId(int auctionId) {
                this.auctionId = auctionId;
            }

            public String getBidNo() {
                return bidNo;
            }

            public void setBidNo(String bidNo) {
                this.bidNo = bidNo;
            }
        }
    }
}
