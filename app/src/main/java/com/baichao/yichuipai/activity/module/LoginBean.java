package com.baichao.yichuipai.activity.module;

/**
 * Created by pll on 2017/5/9.
 */

public class LoginBean {

    /**
     * code : 1
     * msg : 登录成功
     * data : {"id":1,"userNo":"","headImg":"","nickname":"6b24a807-0ae4-45c7-86f1-1fd276166a83","sex":"","birthday":null,"signature":"","mobile":"15288433261","email":"","region":"","street":"","status":1,"personAuthStatus":0,"companyAuthStatus":0,"errorLoginCount":0,"userToken":{"access_token":"ea3654c7-c1cd-4697-8227-bc6dc4dedbe2","expire_time":"1496311188"}}
     */

    private String code;
    private String msg;
    /**
     * id : 1
     * userNo :
     * headImg :
     * nickname : 6b24a807-0ae4-45c7-86f1-1fd276166a83
     * sex :
     * birthday : null
     * signature :
     * mobile : 15288433261
     * email :
     * region :
     * street :
     * status : 1
     * personAuthStatus : 0
     * companyAuthStatus : 0
     * errorLoginCount : 0
     * userToken : {"access_token":"ea3654c7-c1cd-4697-8227-bc6dc4dedbe2","expire_time":"1496311188"}
     */

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
        private int status;
        private int personAuthStatus;
        private int companyAuthStatus;
        private int errorLoginCount;
        /**
         * access_token : ea3654c7-c1cd-4697-8227-bc6dc4dedbe2
         * expire_time : 1496311188
         */

        private UserTokenBean userToken;

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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public UserTokenBean getUserToken() {
            return userToken;
        }

        public void setUserToken(UserTokenBean userToken) {
            this.userToken = userToken;
        }

        public static class UserTokenBean {
            private String access_token;
            private String expire_time;

            public String getAccess_token() {
                return access_token;
            }

            public void setAccess_token(String access_token) {
                this.access_token = access_token;
            }

            public String getExpire_time() {
                return expire_time;
            }

            public void setExpire_time(String expire_time) {
                this.expire_time = expire_time;
            }
        }
    }
}
