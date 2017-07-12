package com.baichao.yichuipai.fragment.moudule;

import java.util.List;

/**
 * Created by pll on 2017/5/3.
 */

public class HomeBean {

    /**
     * code : 1
     * msg : 操作成功！
     * data : {"num":1,"rowCount":12,"startRow":0,"pageSize":5,"navCount":3,"prev":1,"next":2,"first":1,"last":3,"begin":1,"end":3,"navNum":5,"parameter":null,"pageData":[{"houseId":25,"title":"滇池旅游度假区别墅火热拍卖中","evalautePrice":1000000,"imgUrl":"","houseStatus":1,"seeHouseStatus":0,"startPrice":100000,"auctionStartTime":"2017-06-22 16:03:12.0","currentPrice":1000002,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":6,"auctionId":5,"pv":0,"signStatus":0,"liveStatus":0,"auctionStatus":0},{"houseId":27,"title":"滇池旅游度假区别墅火热拍卖中","evalautePrice":1000000,"imgUrl":"","houseStatus":1,"seeHouseStatus":0,"startPrice":100000,"auctionStartTime":null,"currentPrice":0,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":3,"auctionId":7,"pv":0,"signStatus":0,"liveStatus":0,"auctionStatus":0},{"houseId":29,"title":"滇池旅游度假区别墅火热拍卖中","evalautePrice":1000000,"imgUrl":"","houseStatus":1,"seeHouseStatus":0,"startPrice":100000,"auctionStartTime":null,"currentPrice":0,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":3,"auctionId":9,"pv":0,"signStatus":0,"liveStatus":0,"auctionStatus":0},{"houseId":31,"title":"滇池旅游度假区别墅火热拍卖中","evalautePrice":1000000,"imgUrl":"","houseStatus":1,"seeHouseStatus":0,"startPrice":100000,"auctionStartTime":null,"currentPrice":0,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":3,"auctionId":11,"pv":0,"signStatus":0,"liveStatus":0,"auctionStatus":0},{"houseId":33,"title":"滇池旅游度假区别墅火热拍卖中","evalautePrice":1000000,"imgUrl":"","houseStatus":1,"seeHouseStatus":0,"startPrice":100000,"auctionStartTime":null,"currentPrice":0,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":3,"auctionId":13,"pv":0,"signStatus":0,"liveStatus":0,"auctionStatus":0}]}
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
         * rowCount : 12
         * startRow : 0
         * pageSize : 5
         * navCount : 3
         * prev : 1
         * next : 2
         * first : 1
         * last : 3
         * begin : 1
         * end : 3
         * navNum : 5
         * parameter : null
         * pageData : [{"houseId":25,"title":"滇池旅游度假区别墅火热拍卖中","evalautePrice":1000000,"imgUrl":"","houseStatus":1,"seeHouseStatus":0,"startPrice":100000,"auctionStartTime":"2017-06-22 16:03:12.0","currentPrice":1000002,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":6,"auctionId":5,"pv":0,"signStatus":0,"liveStatus":0,"auctionStatus":0},{"houseId":27,"title":"滇池旅游度假区别墅火热拍卖中","evalautePrice":1000000,"imgUrl":"","houseStatus":1,"seeHouseStatus":0,"startPrice":100000,"auctionStartTime":null,"currentPrice":0,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":3,"auctionId":7,"pv":0,"signStatus":0,"liveStatus":0,"auctionStatus":0},{"houseId":29,"title":"滇池旅游度假区别墅火热拍卖中","evalautePrice":1000000,"imgUrl":"","houseStatus":1,"seeHouseStatus":0,"startPrice":100000,"auctionStartTime":null,"currentPrice":0,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":3,"auctionId":9,"pv":0,"signStatus":0,"liveStatus":0,"auctionStatus":0},{"houseId":31,"title":"滇池旅游度假区别墅火热拍卖中","evalautePrice":1000000,"imgUrl":"","houseStatus":1,"seeHouseStatus":0,"startPrice":100000,"auctionStartTime":null,"currentPrice":0,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":3,"auctionId":11,"pv":0,"signStatus":0,"liveStatus":0,"auctionStatus":0},{"houseId":33,"title":"滇池旅游度假区别墅火热拍卖中","evalautePrice":1000000,"imgUrl":"","houseStatus":1,"seeHouseStatus":0,"startPrice":100000,"auctionStartTime":null,"currentPrice":0,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":3,"auctionId":13,"pv":0,"signStatus":0,"liveStatus":0,"auctionStatus":0}]
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
             * houseId : 25
             * title : 滇池旅游度假区别墅火热拍卖中
             * evalautePrice : 1000000
             * imgUrl :
             * houseStatus : 1
             * seeHouseStatus : 0
             * startPrice : 100000
             * auctionStartTime : 2017-06-22 16:03:12.0
             * currentPrice : 1000002
             * collectionCount : 0
             * houseVideo :
             * watchCount : 0
             * bidCount : 6
             * auctionId : 5
             * pv : 0
             * signStatus : 0
             * liveStatus : 0
             * auctionStatus : 0
             */

            private int houseId;
            private String title;
            private int evalautePrice;
            private String imgUrl;
            private int houseStatus;
            private int seeHouseStatus;
            private int startPrice;
            private String auctionStartTime;
            private int currentPrice;
            private int collectionCount;
            private String houseVideo;
            private int watchCount;
            private int bidCount;
            private int auctionId;
            private int pv;
            private int signStatus;
            private int liveStatus;
            private int auctionStatus;

            public int getHouseId() {
                return houseId;
            }

            public void setHouseId(int houseId) {
                this.houseId = houseId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getEvalautePrice() {
                return evalautePrice;
            }

            public void setEvalautePrice(int evalautePrice) {
                this.evalautePrice = evalautePrice;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public int getHouseStatus() {
                return houseStatus;
            }

            public void setHouseStatus(int houseStatus) {
                this.houseStatus = houseStatus;
            }

            public int getSeeHouseStatus() {
                return seeHouseStatus;
            }

            public void setSeeHouseStatus(int seeHouseStatus) {
                this.seeHouseStatus = seeHouseStatus;
            }

            public int getStartPrice() {
                return startPrice;
            }

            public void setStartPrice(int startPrice) {
                this.startPrice = startPrice;
            }

            public String getAuctionStartTime() {
                return auctionStartTime;
            }

            public void setAuctionStartTime(String auctionStartTime) {
                this.auctionStartTime = auctionStartTime;
            }

            public int getCurrentPrice() {
                return currentPrice;
            }

            public void setCurrentPrice(int currentPrice) {
                this.currentPrice = currentPrice;
            }

            public int getCollectionCount() {
                return collectionCount;
            }

            public void setCollectionCount(int collectionCount) {
                this.collectionCount = collectionCount;
            }

            public String getHouseVideo() {
                return houseVideo;
            }

            public void setHouseVideo(String houseVideo) {
                this.houseVideo = houseVideo;
            }

            public int getWatchCount() {
                return watchCount;
            }

            public void setWatchCount(int watchCount) {
                this.watchCount = watchCount;
            }

            public int getBidCount() {
                return bidCount;
            }

            public void setBidCount(int bidCount) {
                this.bidCount = bidCount;
            }

            public int getAuctionId() {
                return auctionId;
            }

            public void setAuctionId(int auctionId) {
                this.auctionId = auctionId;
            }

            public int getPv() {
                return pv;
            }

            public void setPv(int pv) {
                this.pv = pv;
            }

            public int getSignStatus() {
                return signStatus;
            }

            public void setSignStatus(int signStatus) {
                this.signStatus = signStatus;
            }

            public int getLiveStatus() {
                return liveStatus;
            }

            public void setLiveStatus(int liveStatus) {
                this.liveStatus = liveStatus;
            }

            public int getAuctionStatus() {
                return auctionStatus;
            }

            public void setAuctionStatus(int auctionStatus) {
                this.auctionStatus = auctionStatus;
            }
        }
    }
}
