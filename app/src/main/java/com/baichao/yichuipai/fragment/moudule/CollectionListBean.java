package com.baichao.yichuipai.fragment.moudule;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */

public class CollectionListBean {

    /**
     * code : 1
     * msg : 操作成功！
     * data : {"num":1,"rowCount":1,"startRow":0,"pageSize":5,"navCount":1,"prev":1,"next":1,"first":1,"last":1,"begin":1,"end":1,"navNum":5,"parameter":null,"pageData":[{"houseInfo":{"id":8895,"housePhotoId":0,"title":"云南映象-501","imgUrl":"/2017/07/13/201707131754001.jpg","district":"530103","location":"穿金路","fullView":"","evalautePrice":1000000,"sort":3,"pv":8,"seeStartTime":null,"shelfTime":1499939942000,"createTime":1499939682000,"houseStatus":1,"status":1,"seeHouseStatus":0,"collectionId":216,"collectionType":0,"collectionStatus":1,"userId":38,"collectionHouseId":8895,"auctionId":8897},"auctionMeeting":{"id":949,"regionId":530100,"name":"云南映象专场拍卖第二次","createOrgUserId":"admin","updateOrgUserId":"admin","depositPrice":20000,"signCount":0,"meetingStatus":1,"signStatus":2,"shelfStatus":1,"signStartTime":1499875200000,"signEndTime":1499939842000,"startTime":1499875200000,"createTime":1499939864000,"updateTime":1499941730000,"status":1},"auctionInfo":{"id":8897,"houseId":8895,"anchorId":0,"type":"变卖","startPrice":500000,"increasePrice":5000,"currentPrice":500000,"collectionCount":2,"houseVideo":"","watchCount":0,"bidCount":0,"createTime":1499940203000,"bidRule":"价高者得","consultWay":"张三：10000","sellPeriod":"30天","auctionStartTime":null,"signStartTime":null,"signEndTime":null,"signStatus":0,"liveStatus":0,"auctionStatus":2,"status":1,"auctionMeetingId":949},"auctionRecord":null,"auctionResult":null,"countRecord":0}]}
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
         * rowCount : 1
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
         * pageData : [{"houseInfo":{"id":8895,"housePhotoId":0,"title":"云南映象-501","imgUrl":"/2017/07/13/201707131754001.jpg","district":"530103","location":"穿金路","fullView":"","evalautePrice":1000000,"sort":3,"pv":8,"seeStartTime":null,"shelfTime":1499939942000,"createTime":1499939682000,"houseStatus":1,"status":1,"seeHouseStatus":0,"collectionId":216,"collectionType":0,"collectionStatus":1,"userId":38,"collectionHouseId":8895,"auctionId":8897},"auctionMeeting":{"id":949,"regionId":530100,"name":"云南映象专场拍卖第二次","createOrgUserId":"admin","updateOrgUserId":"admin","depositPrice":20000,"signCount":0,"meetingStatus":1,"signStatus":2,"shelfStatus":1,"signStartTime":1499875200000,"signEndTime":1499939842000,"startTime":1499875200000,"createTime":1499939864000,"updateTime":1499941730000,"status":1},"auctionInfo":{"id":8897,"houseId":8895,"anchorId":0,"type":"变卖","startPrice":500000,"increasePrice":5000,"currentPrice":500000,"collectionCount":2,"houseVideo":"","watchCount":0,"bidCount":0,"createTime":1499940203000,"bidRule":"价高者得","consultWay":"张三：10000","sellPeriod":"30天","auctionStartTime":null,"signStartTime":null,"signEndTime":null,"signStatus":0,"liveStatus":0,"auctionStatus":2,"status":1,"auctionMeetingId":949},"auctionRecord":null,"auctionResult":null,"countRecord":0}]
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
             * houseInfo : {"id":8895,"housePhotoId":0,"title":"云南映象-501","imgUrl":"/2017/07/13/201707131754001.jpg","district":"530103","location":"穿金路","fullView":"","evalautePrice":1000000,"sort":3,"pv":8,"seeStartTime":null,"shelfTime":1499939942000,"createTime":1499939682000,"houseStatus":1,"status":1,"seeHouseStatus":0,"collectionId":216,"collectionType":0,"collectionStatus":1,"userId":38,"collectionHouseId":8895,"auctionId":8897}
             * auctionMeeting : {"id":949,"regionId":530100,"name":"云南映象专场拍卖第二次","createOrgUserId":"admin","updateOrgUserId":"admin","depositPrice":20000,"signCount":0,"meetingStatus":1,"signStatus":2,"shelfStatus":1,"signStartTime":1499875200000,"signEndTime":1499939842000,"startTime":1499875200000,"createTime":1499939864000,"updateTime":1499941730000,"status":1}
             * auctionInfo : {"id":8897,"houseId":8895,"anchorId":0,"type":"变卖","startPrice":500000,"increasePrice":5000,"currentPrice":500000,"collectionCount":2,"houseVideo":"","watchCount":0,"bidCount":0,"createTime":1499940203000,"bidRule":"价高者得","consultWay":"张三：10000","sellPeriod":"30天","auctionStartTime":null,"signStartTime":null,"signEndTime":null,"signStatus":0,"liveStatus":0,"auctionStatus":2,"status":1,"auctionMeetingId":949}
             * auctionRecord : null
             * auctionResult : null
             * countRecord : 0
             */

            private HouseInfoBean houseInfo;
            private AuctionMeetingBean auctionMeeting;
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

            public AuctionMeetingBean getAuctionMeeting() {
                return auctionMeeting;
            }

            public void setAuctionMeeting(AuctionMeetingBean auctionMeeting) {
                this.auctionMeeting = auctionMeeting;
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
                 * id : 8895
                 * housePhotoId : 0
                 * title : 云南映象-501
                 * imgUrl : /2017/07/13/201707131754001.jpg
                 * district : 530103
                 * location : 穿金路
                 * fullView :
                 * evalautePrice : 1000000
                 * sort : 3
                 * pv : 8
                 * seeStartTime : null
                 * shelfTime : 1499939942000
                 * createTime : 1499939682000
                 * houseStatus : 1
                 * status : 1
                 * seeHouseStatus : 0
                 * collectionId : 216
                 * collectionType : 0
                 * collectionStatus : 1
                 * userId : 38
                 * collectionHouseId : 8895
                 * auctionId : 8897
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
                private Object seeStartTime;
                private long shelfTime;
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

                public Object getSeeStartTime() {
                    return seeStartTime;
                }

                public void setSeeStartTime(Object seeStartTime) {
                    this.seeStartTime = seeStartTime;
                }

                public long getShelfTime() {
                    return shelfTime;
                }

                public void setShelfTime(long shelfTime) {
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

            public static class AuctionMeetingBean {
                /**
                 * id : 949
                 * regionId : 530100
                 * name : 云南映象专场拍卖第二次
                 * createOrgUserId : admin
                 * updateOrgUserId : admin
                 * depositPrice : 20000
                 * signCount : 0
                 * meetingStatus : 1
                 * signStatus : 2
                 * shelfStatus : 1
                 * signStartTime : 1499875200000
                 * signEndTime : 1499939842000
                 * startTime : 1499875200000
                 * createTime : 1499939864000
                 * updateTime : 1499941730000
                 * status : 1
                 */

                private int id;
                private int regionId;
                private String name;
                private String createOrgUserId;
                private String updateOrgUserId;
                private int depositPrice;
                private int signCount;
                private int meetingStatus;
                private int signStatus;
                private int shelfStatus;
                private long signStartTime;
                private long signEndTime;
                private long startTime;
                private long createTime;
                private long updateTime;
                private int status;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getRegionId() {
                    return regionId;
                }

                public void setRegionId(int regionId) {
                    this.regionId = regionId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCreateOrgUserId() {
                    return createOrgUserId;
                }

                public void setCreateOrgUserId(String createOrgUserId) {
                    this.createOrgUserId = createOrgUserId;
                }

                public String getUpdateOrgUserId() {
                    return updateOrgUserId;
                }

                public void setUpdateOrgUserId(String updateOrgUserId) {
                    this.updateOrgUserId = updateOrgUserId;
                }

                public int getDepositPrice() {
                    return depositPrice;
                }

                public void setDepositPrice(int depositPrice) {
                    this.depositPrice = depositPrice;
                }

                public int getSignCount() {
                    return signCount;
                }

                public void setSignCount(int signCount) {
                    this.signCount = signCount;
                }

                public int getMeetingStatus() {
                    return meetingStatus;
                }

                public void setMeetingStatus(int meetingStatus) {
                    this.meetingStatus = meetingStatus;
                }

                public int getSignStatus() {
                    return signStatus;
                }

                public void setSignStatus(int signStatus) {
                    this.signStatus = signStatus;
                }

                public int getShelfStatus() {
                    return shelfStatus;
                }

                public void setShelfStatus(int shelfStatus) {
                    this.shelfStatus = shelfStatus;
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

                public long getStartTime() {
                    return startTime;
                }

                public void setStartTime(long startTime) {
                    this.startTime = startTime;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public long getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(long updateTime) {
                    this.updateTime = updateTime;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }
            }

            public static class AuctionInfoBean {
                /**
                 * id : 8897
                 * houseId : 8895
                 * anchorId : 0
                 * type : 变卖
                 * startPrice : 500000
                 * increasePrice : 5000
                 * currentPrice : 500000
                 * collectionCount : 2
                 * houseVideo :
                 * watchCount : 0
                 * bidCount : 0
                 * createTime : 1499940203000
                 * bidRule : 价高者得
                 * consultWay : 张三：10000
                 * sellPeriod : 30天
                 * auctionStartTime : null
                 * signStartTime : null
                 * signEndTime : null
                 * signStatus : 0
                 * liveStatus : 0
                 * auctionStatus : 2
                 * status : 1
                 * auctionMeetingId : 949
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
                private Object auctionStartTime;
                private Object signStartTime;
                private Object signEndTime;
                private int signStatus;
                private int liveStatus;
                private int auctionStatus;
                private int status;
                private int auctionMeetingId;

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

                public Object getAuctionStartTime() {
                    return auctionStartTime;
                }

                public void setAuctionStartTime(Object auctionStartTime) {
                    this.auctionStartTime = auctionStartTime;
                }

                public Object getSignStartTime() {
                    return signStartTime;
                }

                public void setSignStartTime(Object signStartTime) {
                    this.signStartTime = signStartTime;
                }

                public Object getSignEndTime() {
                    return signEndTime;
                }

                public void setSignEndTime(Object signEndTime) {
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

                public int getAuctionMeetingId() {
                    return auctionMeetingId;
                }

                public void setAuctionMeetingId(int auctionMeetingId) {
                    this.auctionMeetingId = auctionMeetingId;
                }
            }
        }
    }
}
