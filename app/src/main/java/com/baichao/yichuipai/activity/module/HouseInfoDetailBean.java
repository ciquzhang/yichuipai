package com.baichao.yichuipai.activity.module;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */

public class HouseInfoDetailBean {

    /**
     * code : 1
     * msg : 操作成功！
     * data : {"houseInfo":{"id":63,"housePhotoId":0,"title":"正常拍卖","imgUrl":"/2017/06/28/2017062811562354.jpg","district":"订单","location":"点点滴滴","fullView":"","evalautePrice":455225,"sort":100,"pv":104,"seeStartTime":1496963726000,"shelfTime":null,"createTime":1498789735000,"houseStatus":1,"status":1,"content":"<p>点点点<\/p>","seeHouseStatus":0},"auctionInfo":{"id":37,"houseId":63,"anchorId":0,"type":"编码","startPrice":null,"increasePrice":10000,"currentPrice":10000,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":0,"createTime":1499132078000,"bidRule":"价高者得","consultWay":"生:13588888888","sellPeriod":"36天","auctionStartTime":1499132095000,"signStartTime":1499132098000,"signEndTime":1499132101000,"signStatus":1,"liveStatus":1,"auctionStatus":2,"status":1,"auctionMeetingId":1},"auctionRecords":null,"auctionResult":null,"userInfo":{"id":30,"userNo":"","headImg":"","nickname":"彭龙龙","sex":"","birthday":null,"signature":"","mobile":"17682343025","email":"","region":"","street":"","createTime":1498784620000,"updateTime":null,"status":1,"password":null,"salt":null,"personAuthStatus":1,"companyAuthStatus":0,"errorLoginCount":0,"tranPassword":null,"tranStatus":null},"auctionSignRecord":null,"houseCollection":{"id":118,"type":0,"status":1,"userId":30,"houseId":63,"auctionId":36},"auctionMeeting":{"id":1,"regionId":1,"name":"测试拍卖会","createOrgUserId":null,"updateOrgUserId":null,"depositPrice":0,"signCount":3,"meetingStatus":0,"signStatus":0,"shelfStatus":1,"signStartTime":1499133070000,"signEndTime":1499133073000,"startTime":1499133061000,"createTime":null,"updateTime":null,"status":1},"housePhotos":[{"id":11,"houseId":63,"imgUrl":"/2017/06/30/20170630102852headimg.png","createTime":1498789735000}],"auctionDeposits":[{"id":2,"userId":30,"amount":20000,"status":1,"count":0,"createTime":1498699444000,"orgUserId":null,"refundDesc":"","refundStatus":0,"refundTime":null,"depositStatus":null},{"id":1,"userId":30,"amount":20000,"status":1,"count":2,"createTime":1498785782000,"orgUserId":null,"refundDesc":"","refundStatus":0,"refundTime":null,"depositStatus":null}]}
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
         * houseInfo : {"id":63,"housePhotoId":0,"title":"正常拍卖","imgUrl":"/2017/06/28/2017062811562354.jpg","district":"订单","location":"点点滴滴","fullView":"","evalautePrice":455225,"sort":100,"pv":104,"seeStartTime":1496963726000,"shelfTime":null,"createTime":1498789735000,"houseStatus":1,"status":1,"content":"<p>点点点<\/p>","seeHouseStatus":0}
         * auctionInfo : {"id":37,"houseId":63,"anchorId":0,"type":"编码","startPrice":null,"increasePrice":10000,"currentPrice":10000,"collectionCount":0,"houseVideo":"","watchCount":0,"bidCount":0,"createTime":1499132078000,"bidRule":"价高者得","consultWay":"生:13588888888","sellPeriod":"36天","auctionStartTime":1499132095000,"signStartTime":1499132098000,"signEndTime":1499132101000,"signStatus":1,"liveStatus":1,"auctionStatus":2,"status":1,"auctionMeetingId":1}
         * auctionRecords : null
         * auctionResult : null
         * userInfo : {"id":30,"userNo":"","headImg":"","nickname":"彭龙龙","sex":"","birthday":null,"signature":"","mobile":"17682343025","email":"","region":"","street":"","createTime":1498784620000,"updateTime":null,"status":1,"password":null,"salt":null,"personAuthStatus":1,"companyAuthStatus":0,"errorLoginCount":0,"tranPassword":null,"tranStatus":null}
         * auctionSignRecord : null
         * houseCollection : {"id":118,"type":0,"status":1,"userId":30,"houseId":63,"auctionId":36}
         * auctionMeeting : {"id":1,"regionId":1,"name":"测试拍卖会","createOrgUserId":null,"updateOrgUserId":null,"depositPrice":0,"signCount":3,"meetingStatus":0,"signStatus":0,"shelfStatus":1,"signStartTime":1499133070000,"signEndTime":1499133073000,"startTime":1499133061000,"createTime":null,"updateTime":null,"status":1}
         * housePhotos : [{"id":11,"houseId":63,"imgUrl":"/2017/06/30/20170630102852headimg.png","createTime":1498789735000}]
         * auctionDeposits : [{"id":2,"userId":30,"amount":20000,"status":1,"count":0,"createTime":1498699444000,"orgUserId":null,"refundDesc":"","refundStatus":0,"refundTime":null,"depositStatus":null},{"id":1,"userId":30,"amount":20000,"status":1,"count":2,"createTime":1498785782000,"orgUserId":null,"refundDesc":"","refundStatus":0,"refundTime":null,"depositStatus":null}]
         */

        private HouseInfoBean houseInfo;
        private AuctionInfoBean auctionInfo;
        private List<AuctionRecordsBean> auctionRecords;
        private Object auctionResult;
        private UserInfoBean userInfo;
        private AuctionSignRecordBean auctionSignRecord;
        private HouseCollectionBean houseCollection;
        private AuctionMeetingBean auctionMeeting;
        private List<HousePhotosBean> housePhotos;
        private List<AuctionDepositsBean> auctionDeposits;

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

        public List<AuctionRecordsBean> getAuctionRecords() {
            return auctionRecords;
        }

        public void setAuctionRecords(List<AuctionRecordsBean> auctionRecords) {
            this.auctionRecords = auctionRecords;
        }

        public Object getAuctionResult() {
            return auctionResult;
        }

        public void setAuctionResult(Object auctionResult) {
            this.auctionResult = auctionResult;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public AuctionSignRecordBean getAuctionSignRecord() {
            return auctionSignRecord;
        }

        public void setAuctionSignRecord(AuctionSignRecordBean auctionSignRecord) {
            this.auctionSignRecord = auctionSignRecord;
        }

        public HouseCollectionBean getHouseCollection() {
            return houseCollection;
        }

        public void setHouseCollection(HouseCollectionBean houseCollection) {
            this.houseCollection = houseCollection;
        }

        public AuctionMeetingBean getAuctionMeeting() {
            return auctionMeeting;
        }

        public void setAuctionMeeting(AuctionMeetingBean auctionMeeting) {
            this.auctionMeeting = auctionMeeting;
        }

        public List<HousePhotosBean> getHousePhotos() {
            return housePhotos;
        }

        public void setHousePhotos(List<HousePhotosBean> housePhotos) {
            this.housePhotos = housePhotos;
        }

        public List<AuctionDepositsBean> getAuctionDeposits() {
            return auctionDeposits;
        }

        public void setAuctionDeposits(List<AuctionDepositsBean> auctionDeposits) {
            this.auctionDeposits = auctionDeposits;
        }

        public static class AuctionSignRecordBean{
            /**
             * id : 17
             * bidNo : A1b0103
             * status : 1
             * userId : 9
             * auctionId : 27
             * auctionFile :
             * realName : 张三
             * nationalId : 2545525412
             * region : 云南昆明市
             * street : 穿金路
             * createTime : 1498724129000
             * depositId : 1
             */

            private int id;
            private String bidNo;
            private int status;
            private int userId;
            private int auctionId;
            private String auctionFile;
            private String realName;
            private String nationalId;
            private String region;
            private String street;
            private long createTime;
            private int depositId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getBidNo() {
                return bidNo;
            }

            public void setBidNo(String bidNo) {
                this.bidNo = bidNo;
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

            public String getAuctionFile() {
                return auctionFile;
            }

            public void setAuctionFile(String auctionFile) {
                this.auctionFile = auctionFile;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getNationalId() {
                return nationalId;
            }

            public void setNationalId(String nationalId) {
                this.nationalId = nationalId;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getDepositId() {
                return depositId;
            }

            public void setDepositId(int depositId) {
                this.depositId = depositId;
            }
        }

        public static class AuctionRecordsBean{
            private int id;
            private int price;
            private long bidTime;
            private int bidStatus;
            private int status;
            private int userId;
            private int auctionId;
            private String bidNo;

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

        public static class HouseInfoBean {
            /**
             * id : 63
             * housePhotoId : 0
             * title : 正常拍卖
             * imgUrl : /2017/06/28/2017062811562354.jpg
             * district : 订单
             * location : 点点滴滴
             * fullView :
             * evalautePrice : 455225
             * sort : 100
             * pv : 104
             * seeStartTime : 1496963726000
             * shelfTime : null
             * createTime : 1498789735000
             * houseStatus : 1
             * status : 1
             * content : <p>点点点</p>
             * seeHouseStatus : 0
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
            private String content;
            private int seeHouseStatus;

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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getSeeHouseStatus() {
                return seeHouseStatus;
            }

            public void setSeeHouseStatus(int seeHouseStatus) {
                this.seeHouseStatus = seeHouseStatus;
            }
        }

        public static class AuctionInfoBean {
            /**
             * id : 37
             * houseId : 63
             * anchorId : 0
             * type : 编码
             * startPrice : null
             * increasePrice : 10000
             * currentPrice : 10000
             * collectionCount : 0
             * houseVideo :
             * watchCount : 0
             * bidCount : 0
             * createTime : 1499132078000
             * bidRule : 价高者得
             * consultWay : 生:13588888888
             * sellPeriod : 36天
             * auctionStartTime : 1499132095000
             * signStartTime : 1499132098000
             * signEndTime : 1499132101000
             * signStatus : 1
             * liveStatus : 1
             * auctionStatus : 2
             * status : 1
             * auctionMeetingId : 1
             */

            private int id;
            private int houseId;
            private int anchorId;
            private String type;
            private Object startPrice;
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

            public Object getStartPrice() {
                return startPrice;
            }

            public void setStartPrice(Object startPrice) {
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

            public int getAuctionMeetingId() {
                return auctionMeetingId;
            }

            public void setAuctionMeetingId(int auctionMeetingId) {
                this.auctionMeetingId = auctionMeetingId;
            }
        }

        public static class UserInfoBean {
            /**
             * id : 30
             * userNo :
             * headImg :
             * nickname : 彭龙龙
             * sex :
             * birthday : null
             * signature :
             * mobile : 17682343025
             * email :
             * region :
             * street :
             * createTime : 1498784620000
             * updateTime : null
             * status : 1
             * password : null
             * salt : null
             * personAuthStatus : 1
             * companyAuthStatus : 0
             * errorLoginCount : 0
             * tranPassword : null
             * tranStatus : null
             */

            private int id;
            private String userNo;
            private String headImg;
            private String nickname;
            private String sex;
            private Object birthday;
            private String signature;
            private String mobile;
            private String email;
            private String region;
            private String street;
            private long createTime;
            private Object updateTime;
            private int status;
            private Object password;
            private Object salt;
            private int personAuthStatus;
            private int companyAuthStatus;
            private int errorLoginCount;
            private Object tranPassword;
            private Object tranStatus;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUserNo() {
                return userNo;
            }

            public void setUserNo(String userNo) {
                this.userNo = userNo;
            }

            public String getHeadImg() {
                return headImg;
            }

            public void setHeadImg(String headImg) {
                this.headImg = headImg;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public Object getBirthday() {
                return birthday;
            }

            public void setBirthday(Object birthday) {
                this.birthday = birthday;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public Object getSalt() {
                return salt;
            }

            public void setSalt(Object salt) {
                this.salt = salt;
            }

            public int getPersonAuthStatus() {
                return personAuthStatus;
            }

            public void setPersonAuthStatus(int personAuthStatus) {
                this.personAuthStatus = personAuthStatus;
            }

            public int getCompanyAuthStatus() {
                return companyAuthStatus;
            }

            public void setCompanyAuthStatus(int companyAuthStatus) {
                this.companyAuthStatus = companyAuthStatus;
            }

            public int getErrorLoginCount() {
                return errorLoginCount;
            }

            public void setErrorLoginCount(int errorLoginCount) {
                this.errorLoginCount = errorLoginCount;
            }

            public Object getTranPassword() {
                return tranPassword;
            }

            public void setTranPassword(Object tranPassword) {
                this.tranPassword = tranPassword;
            }

            public Object getTranStatus() {
                return tranStatus;
            }

            public void setTranStatus(Object tranStatus) {
                this.tranStatus = tranStatus;
            }
        }

        public static class HouseCollectionBean {
            /**
             * id : 118
             * type : 0
             * status : 1
             * userId : 30
             * houseId : 63
             * auctionId : 36
             */

            private int id;
            private int type;
            private int status;
            private int userId;
            private int houseId;
            private int auctionId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

            public int getHouseId() {
                return houseId;
            }

            public void setHouseId(int houseId) {
                this.houseId = houseId;
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
             * id : 1
             * regionId : 1
             * name : 测试拍卖会
             * createOrgUserId : null
             * updateOrgUserId : null
             * depositPrice : 0
             * signCount : 3
             * meetingStatus : 0
             * signStatus : 0
             * shelfStatus : 1
             * signStartTime : 1499133070000
             * signEndTime : 1499133073000
             * startTime : 1499133061000
             * createTime : null
             * updateTime : null
             * status : 1
             */

            private int id;
            private int regionId;
            private String name;
            private Object createOrgUserId;
            private Object updateOrgUserId;
            private int depositPrice;
            private int signCount;
            private int meetingStatus;
            private int signStatus;
            private int shelfStatus;
            private long signStartTime;
            private long signEndTime;
            private long startTime;
            private Object createTime;
            private Object updateTime;
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

            public Object getCreateOrgUserId() {
                return createOrgUserId;
            }

            public void setCreateOrgUserId(Object createOrgUserId) {
                this.createOrgUserId = createOrgUserId;
            }

            public Object getUpdateOrgUserId() {
                return updateOrgUserId;
            }

            public void setUpdateOrgUserId(Object updateOrgUserId) {
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

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class HousePhotosBean {
            /**
             * id : 11
             * houseId : 63
             * imgUrl : /2017/06/30/20170630102852headimg.png
             * createTime : 1498789735000
             */

            private int id;
            private int houseId;
            private String imgUrl;
            private long createTime;

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

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }
        }

        public static class AuctionDepositsBean {
            /**
             * id : 2
             * userId : 30
             * amount : 20000
             * status : 1
             * count : 0
             * createTime : 1498699444000
             * orgUserId : null
             * refundDesc :
             * refundStatus : 0
             * refundTime : null
             * depositStatus : null
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
            private Object depositStatus;

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

            public Object getDepositStatus() {
                return depositStatus;
            }

            public void setDepositStatus(Object depositStatus) {
                this.depositStatus = depositStatus;
            }
        }
    }
}
