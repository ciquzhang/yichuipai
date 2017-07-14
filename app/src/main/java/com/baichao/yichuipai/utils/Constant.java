package com.baichao.yichuipai.utils;

/**
 * Created by pll on 2017/5/5.
 */

public class Constant {

    public static final int REQUEST_LOGIN = 1;//启动登录界面的request

    public static final int AUTH_PERSON = 1;//个人认证状态

    public static final int AUTH_COMPANY = 2;//企业认证状态

    public static final int RESULT_LOGIN = 2;//登录成功的

    public static final int REQUEST_APPROVE_P = 3;//启动个人认证的request

    public static final int RESULT_APPROVE_P = 4;//个人认证成功

    public static final int RESULT_APPROVE_C = 5;//个人认证成功

    public static final int REQUEST_APPROVE_P_INFORMATION = 7;//个人认证--》上传材料证明

    public static final int REQUEST_APPROVE_C_INFORMATION = 8;//企业认证--》上传材料证明

    public static final int REQUEST_APPROVE_C = 8;//启动企业认证

    public static final int RESULT_PICTURE = 8;//保存上传图片信息

    public static final int REQUEST_CHANGE_INFORMATION = 9;//启动修改个人资料

    public static final int REQUEST_LIVE = 9;//直播界面启动登录

    public static final int REQUEST_SIGN = 12;//直播界面启动登录

    public static final int RESULT_LIVE_TO_MY= 10;//直播界面启动登录

    public static final int REQUEST_LIVE_TO_MY= 11;//直播界面启动登录

    public static final int REQUEST_SETTING= 12;//我的-->设置

    public static final int RESULT_SETTING= 13;//退出登录成功

    public static final String ACTION_NAME= "110";//登录成功发送广播

    public static final String ACTION_COLLECT= "111";//收藏成功发送的广播

    public static final int TAKE_PICTURE_FRONT = 0;//选择拍照(正面)
    public static final int CHOOSE_PICTURE_FRONT = 1;//选择相册(正面)
    public static final int TAKE_PICTURE_CONTRARY = 2;//选择拍照(反面)
    public static final int CHOOSE_PICTURE_CONTRARY = 3;//选择相册(反面)
    public static final int TAKE_PICTURE_OTHER = 4;//选择拍照(手持)
    public static final int CHOOSE_PICTURE_OTHER = 5;//选择相册(手持)
    public static final int TAKE_PICTURE_BUSINESS = 6;//选择拍照(营业执照)
    public static final int CHOOSE_PICTURE_BUSINESS = 7;//选择相册(营业执照)

    public static final String[] CHANNELS = new String[]{"收藏", "已报名", "已拍"};

    public static final String NET_APP = "http://47.93.58.118:8081/auction-console/publicApi/";

    public static final String NET_APP_PRIVATE = "http://47.93.58.118:8081/auction-console/api/";

    public static final String NET_HOUSE = NET_APP  + "house/";//获取房屋列表

    public static final String NET_COLLECT_LIST = NET_APP_PRIVATE  + "user/auction/";//获取收藏列表

    public static final String NET_DEPOSIT = NET_APP_PRIVATE  + "user/manage/";//押金详情

    public static final String NET_COLLECTION = NET_APP_PRIVATE  + "auction/";//收藏房屋列表

    public static final String NET_APP_FILE = "http://47.93.58.118:8081/auction-console/api/img/upload";

    public static final String APP_IMAGE = "http://47.93.58.118:8081/auction-console/upload/admin/images";
}
