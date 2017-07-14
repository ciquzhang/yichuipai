package com.baichao.yichuipai.fragment.moudule;

/**
 * Created by Administrator on 2017/7/14.
 */

public class UserMessageBean {

    /**
     * code : 1
     * msg : 请求成功
     * data : {"personAuth":{"authPersonStatus":"1","authStatusMsg":"已认证"},"user":{"id":38,"userNo":"","headImg":"","nickname":"31b198da-980d-4074-a8e2-d86b67428c5c","sex":"","birthday":null,"signature":"","mobile":"17682343025","email":"","region":"","street":"","createTime":1499945702000,"updateTime":null,"status":1,"password":"","salt":null,"personAuthStatus":1,"companyAuthStatus":0,"errorLoginCount":0,"tranPassword":"","tranStatus":0},"companyAuth":{"authCompanyStatus":"2","authStatusMsg":"审核中"}}
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
         * personAuth : {"authPersonStatus":"1","authStatusMsg":"已认证"}
         * user : {"id":38,"userNo":"","headImg":"","nickname":"31b198da-980d-4074-a8e2-d86b67428c5c","sex":"","birthday":null,"signature":"","mobile":"17682343025","email":"","region":"","street":"","createTime":1499945702000,"updateTime":null,"status":1,"password":"","salt":null,"personAuthStatus":1,"companyAuthStatus":0,"errorLoginCount":0,"tranPassword":"","tranStatus":0}
         * companyAuth : {"authCompanyStatus":"2","authStatusMsg":"审核中"}
         */

        private PersonAuthBean personAuth;
        private UserBean user;
        private CompanyAuthBean companyAuth;

        public PersonAuthBean getPersonAuth() {
            return personAuth;
        }

        public void setPersonAuth(PersonAuthBean personAuth) {
            this.personAuth = personAuth;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public CompanyAuthBean getCompanyAuth() {
            return companyAuth;
        }

        public void setCompanyAuth(CompanyAuthBean companyAuth) {
            this.companyAuth = companyAuth;
        }

        public static class PersonAuthBean {
            /**
             * authPersonStatus : 1
             * authStatusMsg : 已认证
             */

            private String authPersonStatus;
            private String authStatusMsg;

            public String getAuthPersonStatus() {
                return authPersonStatus;
            }

            public void setAuthPersonStatus(String authPersonStatus) {
                this.authPersonStatus = authPersonStatus;
            }

            public String getAuthStatusMsg() {
                return authStatusMsg;
            }

            public void setAuthStatusMsg(String authStatusMsg) {
                this.authStatusMsg = authStatusMsg;
            }
        }

        public static class UserBean {
            /**
             * id : 38
             * userNo :
             * headImg :
             * nickname : 31b198da-980d-4074-a8e2-d86b67428c5c
             * sex :
             * birthday : null
             * signature :
             * mobile : 17682343025
             * email :
             * region :
             * street :
             * createTime : 1499945702000
             * updateTime : null
             * status : 1
             * password :
             * salt : null
             * personAuthStatus : 1
             * companyAuthStatus : 0
             * errorLoginCount : 0
             * tranPassword :
             * tranStatus : 0
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
            private String password;
            private Object salt;
            private int personAuthStatus;
            private int companyAuthStatus;
            private int errorLoginCount;
            private String tranPassword;
            private int tranStatus;

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

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
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

            public String getTranPassword() {
                return tranPassword;
            }

            public void setTranPassword(String tranPassword) {
                this.tranPassword = tranPassword;
            }

            public int getTranStatus() {
                return tranStatus;
            }

            public void setTranStatus(int tranStatus) {
                this.tranStatus = tranStatus;
            }
        }

        public static class CompanyAuthBean {
            /**
             * authCompanyStatus : 2
             * authStatusMsg : 审核中
             */

            private String authCompanyStatus;
            private String authStatusMsg;

            public String getAuthCompanyStatus() {
                return authCompanyStatus;
            }

            public void setAuthCompanyStatus(String authCompanyStatus) {
                this.authCompanyStatus = authCompanyStatus;
            }

            public String getAuthStatusMsg() {
                return authStatusMsg;
            }

            public void setAuthStatusMsg(String authStatusMsg) {
                this.authStatusMsg = authStatusMsg;
            }
        }
    }
}
