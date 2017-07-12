package com.baichao.yichuipai.fragment.moudule;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */

public class CollectionListBean {

    /**
     * code : 1
     * msg : 操作成功！
     * data : {"num":1,"rowCount":2,"startRow":0,"pageSize":5,"navCount":1,"prev":1,"next":1,"first":1,"last":1,"begin":1,"end":1,"navNum":5,"parameter":null,"pageData":[{"houseInfo":{"id":62,"housePhotoId":0,"title":"流拍测试","imgUrl":"/2017/06/30/201706301012443.jpg","district":"昆明","location":"北市区","fullView":"","evalautePrice":455225,"sort":2,"pv":102,"seeStartTime":1496964929000,"shelfTime":null,"createTime":1498788897000,"houseStatus":1,"status":1,"seeHouseStatus":0,"collectionId":119,"collectionType":0,"collectionStatus":1,"userId":30,"collectionHouseId":62,"auctionId":35},"auctionInfo":{"id":35,"houseId":62,"anchorId":0,"type":"变卖","startPrice":1000000,"increasePrice":1000,"currentPrice":0,"collectionCount":2,"houseVideo":"","watchCount":0,"bidCount":2,"createTime":1498788961000,"bidRule":"价高者得","consultWay":"杨小姐18547899632","sellPeriod":"36天","auctionStartTime":1496006710000,"signStartTime":1493591414000,"signEndTime":1496093116000,"signStatus":0,"liveStatus":0,"auctionStatus":0,"status":1},"auctionRecord":null,"auctionResult":null,"countRecord":0},{"houseInfo":{"id":63,"housePhotoId":0,"title":"正常拍卖","imgUrl":"/2017/06/30/20170630102652avatarmale.png","district":"订单","location":"点点滴滴","fullView":"","evalautePrice":455225,"sort":100,"pv":103,"seeStartTime":1496963726000,"shelfTime":null,"createTime":1498789735000,"houseStatus":1,"status":1,"seeHouseStatus":0,"collectionId":118,"collectionType":0,"collectionStatus":1,"userId":30,"collectionHouseId":63,"auctionId":36},"auctionInfo":{"id":36,"houseId":63,"anchorId":0,"type":"变卖","startPrice":1000000,"increasePrice":10000,"currentPrice":40000,"collectionCount":2,"houseVideo":"","watchCount":0,"bidCount":1,"createTime":1498789804000,"bidRule":"价高者得","consultWay":"张先生:13588888888","sellPeriod":"36天","auctionStartTime":1498789755000,"signStartTime":1493591417000,"signEndTime":1496713519000,"signStatus":1,"liveStatus":0,"auctionStatus":2,"status":1},"auctionRecord":{"id":47,"price":40000,"bidTime":1498806732000,"bidStatus":1,"status":1,"userId":31,"auctionId":36,"bidNo":"A240001"},"auctionResult":null,"countRecord":4}]}
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
         * rowCount : 2
         * startRow : 0
         * pageSize : 5
         * navCount : 1
         * prev : 1
         * next : 1
         * first : 1
         * last : 1
         * begin : 1
         * end : 1
         * navNum : 5
         * parameter : null
         * pageData : [{"houseInfo":{"id":62,"housePhotoId":0,"title":"流拍测试","imgUrl":"/2017/06/30/201706301012443.jpg","district":"昆明","location":"北市区","fullView":"","evalautePrice":455225,"sort":2,"pv":102,"seeStartTime":1496964929000,"shelfTime":null,"createTime":1498788897000,"houseStatus":1,"status":1,"seeHouseStatus":0,"collectionId":119,"collectionType":0,"collectionStatus":1,"userId":30,"collectionHouseId":62,"auctionId":35},"auctionInfo":{"id":35,"houseId":62,"anchorId":0,"type":"变卖","startPrice":1000000,"increasePrice":1000,"currentPrice":0,"collectionCount":2,"houseVideo":"","watchCount":0,"bidCount":2,"createTime":1498788961000,"bidRule":"价高者得","consultWay":"杨小姐18547899632","sellPeriod":"36天","auctionStartTime":1496006710000,"signStartTime":1493591414000,"signEndTime":1496093116000,"signStatus":0,"liveStatus":0,"auctionStatus":0,"status":1},"auctionRecord":null,"auctionResult":null,"countRecord":0},{"houseInfo":{"id":63,"housePhotoId":0,"title":"正常拍卖","imgUrl":"/2017/06/30/20170630102652avatarmale.png","district":"订单","location":"点点滴滴","fullView":"","evalautePrice":455225,"sort":100,"pv":103,"seeStartTime":1496963726000,"shelfTime":null,"createTime":1498789735000,"houseStatus":1,"status":1,"seeHouseStatus":0,"collectionId":118,"collectionType":0,"collectionStatus":1,"userId":30,"collectionHouseId":63,"auctionId":36},"auctionInfo":{"id":36,"houseId":63,"anchorId":0,"type":"变卖","startPrice":1000000,"increasePrice":10000,"currentPrice":40000,"collectionCount":2,"houseVideo":"","watchCount":0,"bidCount":1,"createTime":1498789804000,"bidRule":"价高者得","consultWay":"张先生:13588888888","sellPeriod":"36天","auctionStartTime":1498789755000,"signStartTime":1493591417000,"signEndTime":1496713519000,"signStatus":1,"liveStatus":0,"auctionStatus":2,"status":1},"auctionRecord":{"id":47,"price":40000,"bidTime":1498806732000,"bidStatus":1,"status":1,"userId":31,"auctionId":36,"bidNo":"A240001"},"auctionResult":null,"countRecord":4}]
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
             * houseInfo : {"id":62,"housePhotoId":0,"title":"流拍测试","imgUrl":"/2017/06/30/201706301012443.jpg","district":"昆明","location":"北市区","fullView":"","evalautePrice":455225,"sort":2,"pv":102,"seeStartTime":1496964929000,"shelfTime":null,"createTime":1498788897000,"houseStatus":1,"status":1,"seeHouseStatus":0,"collectionId":119,"collectionType":0,"collectionStatus":1,"userId":30,"collectionHouseId":62,"auctionId":35}
             * auctionInfo : {"id":35,"houseId":62,"anchorId":0,"type":"变卖","startPrice":1000000,"increasePrice":1000,"currentPrice":0,"collectionCount":2,"houseVideo":"","watchCount":0,"bidCount":2,"createTime":1498788961000,"bidRule":"价高者得","consultWay":"杨小姐18547899632","sellPeriod":"36天","auctionStartTime":1496006710000,"signStartTime":1493591414000,"signEndTime":1496093116000,"signStatus":0,"liveStatus":0,"auctionStatus":0,"status":1}
             * auctionRecord : null
             * auctionResult : null
             * countRecord : 0
             */

            private HouseInfoBean houseInfo;
            private AuctionInfoBean auctionInfo;
            private Object auctionRecord;
            private Object auctionResult;
            private int countRecord;

            public HouseInfoBean getHouseInfo() {
                return houseInfo;
            }

            public void setHouseInfo(HouseInfoBean houseInfo) {
                this.houseInfo = houseInfo;
            }

            public AuctionInfoBean getAuctionInfo() {
                return auctionInfo;
            }

            public void setAuctionInfo(AuctionInfoBean auctionInfo) {
                this.auctionInfo = auctionInfo;
            }

            public Object getAuctionRecord() {
                return auctionRecord;
            }

            public void setAuctionRecord(Object auctionRecord) {
                this.auctionRecord = auctionRecord;
            }

            public Object getAuctionResult() {
                return auctionResult;
            }

            public void setAuctionResult(Object auctionResult) {
                this.auctionResult = auctionResult;
            }

            public int getCountRecord() {
                return countRecord;
            }

            public void setCountRecord(int countRecord) {
                this.countRecord = countRecord;
            }

            public static class HouseInfoBean {
                /**
                 * id : 62
                 * housePhotoId : 0
                 * title : 流拍测试
                 * imgUrl : /2017/06/30/201706301012443.jpg
                 * district : 昆明
                 * location : 北市区
                 * fullView :
                 * evalautePrice : 455225
                 * sort : 2
                 * pv : 102
                 * seeStartTime : 1496964929000
                 * shelfTime : null
                 * createTime : 1498788897000
                 * houseStatus : 1
                 * status : 1
                 * seeHouseStatus : 0
                 * collectionId : 119
                 * collectionType : 0
                 * collectionStatus : 1
                 * userId : 30
                 * collectionHouseId : 62
                 * auctionId : 35
                 */

                private int id;
                private int housePhotoId;
                private String title;
                private String imgUrl;
                private String district;
                private String location;
                private String fullView;
                private int evalautePrice;
                private int sort;
                private int pv;
                private long seeStartTime;
                private Object shelfTime;
                private long createTime;
                private int houseStatus;
                private int status;
                private int seeHouseStatus;
                private int collectionId;
                private int collectionType;
                private int collectionStatus;
                private int userId;
                private int collectionHouseId;
                private int auctionId;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getHousePhotoId() {
                    return housePhotoId;
                }

                public void setHousePhotoId(int housePhotoId) {
                    this.housePhotoId = housePhotoId;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getDistrict() {
                    return district;
                }

                public void setDistrict(String district) {
                    this.district = district;
                }

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public String getFullView() {
                    return fullView;
                }

                public void setFullView(String fullView) {
                    this.fullView = fullView;
                }

                public int getEvalautePrice() {
                    return evalautePrice;
                }

                public void setEvalautePrice(int evalautePrice) {
                    this.evalautePrice = evalautePrice;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public int getPv() {
                    return pv;
                }

                public void setPv(int pv) {
                    this.pv = pv;
                }

                public long getSeeStartTime() {
                    return seeStartTime;
                }

                public void setSeeStartTime(long seeStartTime) {
                    this.seeStartTime = seeStartTime;
                }

                public Object getShelfTime() {
                    return shelfTime;
                }

                public void setShelfTime(Object shelfTime) {
                    this.shelfTime = shelfTime;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public int getHouseStatus() {
                    return houseStatus;
                }

                public void setHouseStatus(int houseStatus) {
                    this.houseStatus = houseStatus;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getSeeHouseStatus() {
                    return seeHouseStatus;
                }

                public void setSeeHouseStatus(int seeHouseStatus) {
                    this.seeHouseStatus = seeHouseStatus;
                }

                public int getCollectionId() {
                    return collectionId;
                }

                public void setCollectionId(int collectionId) {
                    this.collectionId = collectionId;
                }

                public int getCollectionType() {
                    return collectionType;
                }

                public void setCollectionType(int collectionType) {
                    this.collectionType = collectionType;
                }

                public int getCollectionStatus() {
                    return collectionStatus;
                }

                public void setCollectionStatus(int collectionStatus) {
                    this.collectionStatus = collectionStatus;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public int getCollectionHouseId() {
                    return collectionHouseId;
                }

                public void setCollectionHouseId(int collectionHouseId) {
                    this.collectionHouseId = collectionHouseId;
                }

                public int getAuctionId() {
                    return auctionId;
                }

                public void setAuctionId(int auctionId) {
                    this.auctionId = auctionId;
                }
            }

            public static class AuctionInfoBean {
                /**
                 * id : 35
                 * houseId : 62
                 * anchorId : 0
                 * type : 变卖
                 * startPrice : 1000000
                 * increasePrice : 1000
                 * currentPrice : 0
                 * collectionCount : 2
                 * houseVideo :
                 * watchCount : 0
                 * bidCount : 2
                 * createTime : 1498788961000
                 * bidRule : 价高者得
                 * consultWay : 杨小姐18547899632
                 * sellPeriod : 36天
                 * auctionStartTime : 1496006710000
                 * signStartTime : 1493591414000
                 * signEndTime : 1496093116000
                 * signStatus : 0
                 * liveStatus : 0
                 * auctionStatus : 0
                 * status : 1
                 */

                private int id;
                private int houseId;
                private int anchorId;
                private String type;
                private int startPrice;
                private int increasePrice;
                private int currentPrice;
                private int collectionCount;
                private String houseVideo;
                private int watchCount;
                private int bidCount;
                private long createTime;
                private String bidRule;
                private String consultWay;
                private String sellPeriod;
                private long auctionStartTime;
                private long signStartTime;
                private long signEndTime;
                private int signStatus;
                private int liveStatus;
                private int auctionStatus;
                private int status;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getHouseId() {
                    return houseId;
                }

                public void setHouseId(int houseId) {
                    this.houseId = houseId;
                }

                public int getAnchorId() {
                    return anchorId;
                }

                public void setAnchorId(int anchorId) {
                    this.anchorId = anchorId;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getStartPrice() {
                    return startPrice;
                }

                public void setStartPrice(int startPrice) {
                    this.startPrice = startPrice;
                }

                public int getIncreasePrice() {
                    return increasePrice;
                }

                public void setIncreasePrice(int increasePrice) {
                    this.increasePrice = increasePrice;
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

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public String getBidRule() {
                    return bidRule;
                }

                public void setBidRule(String bidRule) {
                    this.bidRule = bidRule;
                }

                public String getConsultWay() {
                    return consultWay;
                }

                public void setConsultWay(String consultWay) {
                    this.consultWay = consultWay;
                }

                public String getSellPeriod() {
                    return sellPeriod;
                }

                public void setSellPeriod(String sellPeriod) {
                    this.sellPeriod = sellPeriod;
                }

                public long getAuctionStartTime() {
                    return auctionStartTime;
                }

                public void setAuctionStartTime(long auctionStartTime) {
                    this.auctionStartTime = auctionStartTime;
                }

                public long getSignStartTime() {
                    return signStartTime;
                }

                public void setSignStartTime(long signStartTime) {
                    this.signStartTime = signStartTime;
                }

                public long getSignEndTime() {
                    return signEndTime;
                }

                public void setSignEndTime(long signEndTime) {
                    this.signEndTime = signEndTime;
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

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }
            }
        }
    }
}
