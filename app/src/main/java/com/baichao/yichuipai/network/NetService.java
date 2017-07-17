package com.baichao.yichuipai.network;

import com.baichao.yichuipai.activity.module.BuyListBean;
import com.baichao.yichuipai.activity.module.CheckIsRegister;
import com.baichao.yichuipai.activity.module.DepositBean;
import com.baichao.yichuipai.activity.module.DepositDetailedBean;
import com.baichao.yichuipai.activity.module.HouseInfoDetailBean;
import com.baichao.yichuipai.activity.module.LoginBean;
import com.baichao.yichuipai.activity.module.MeetingListBean;
import com.baichao.yichuipai.activity.module.NeedDepositBean;
import com.baichao.yichuipai.activity.module.NetForPictureBean;
import com.baichao.yichuipai.activity.module.PApproveBean;
import com.baichao.yichuipai.activity.module.PassAuctionListBean;
import com.baichao.yichuipai.activity.module.RegisterBean;
import com.baichao.yichuipai.activity.module.RegisterCodeBean;
import com.baichao.yichuipai.activity.module.SignBean;
import com.baichao.yichuipai.fragment.moudule.AppliedListBean;
import com.baichao.yichuipai.fragment.moudule.AuthStatusBean;
import com.baichao.yichuipai.fragment.moudule.CollectionBean;
import com.baichao.yichuipai.fragment.moudule.CollectionListBean;
import com.baichao.yichuipai.fragment.moudule.HomeBean;
import com.baichao.yichuipai.fragment.moudule.HousePvBean;
import com.baichao.yichuipai.fragment.moudule.RefreshTokenBean;
import com.baichao.yichuipai.fragment.moudule.TakenListBean;
import com.baichao.yichuipai.fragment.moudule.UserMessageBean;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pll on 2017/5/9.
 */

public interface NetService {
    /**
     * 获取注册验证码
     * @param number
     * @return
     */
    @POST("verifyCode")
    Observable<RegisterCodeBean> getCodeByRegister(@Query("mobile") String number);

    /**
     * 检测是否已经被注册
     * @param number
     * @return
     */
    @POST("isRegister")
    Observable<CheckIsRegister> checkPhone(@Query("mobile") String number);

    /**
     * 注册账户
     * @param number
     * @param userPwd
     * @param mobileCode
     * @return
     */
    @POST("register")
    Observable<RegisterBean> registerCommit(@Query("mobile") String number,
                                            @Query("password") String password,
                                            @Query("verifyCode") String mobileCode);


    /**
     * 登录
     * @param number
     * @param userPwd
     * @return
     */
    @POST("login")
    Observable<LoginBean> loginCommit(@Query("mobile") String mobile,
                                      @Query("password") String password);

    /**
     * 刷新token
     * @param token
     * @return
     */
    @POST("accessToken")
    Observable<RefreshTokenBean> refreshToken(@Query("token") String token);


    /**
     * 个人认证图片上传
     * @param photo_fount
     * @param photo_back
     * @param photo_face
     * @Part MultipartBody.Part photo_fount,
     * @return
     */
    @Multipart
    @POST("upload")
    Observable<NetForPictureBean> loadFilesByPerson(@Header("token") String token,
                                                    @PartMap Map<String, RequestBody> params);

    /**
     * 个人认证
     * @param token
     * @param realName
     * @param idNo
     * @param userId
     * @param idcard_front
     * @param idcard_front_type
     * @param idcard_back
     * @param idcard_back_type
     * @param hand_idcard
     * @param hand_idcard_type
     * @return
     */
    @POST("personAuth")
    Observable<PApproveBean> approveCommit_p(@Header("token") String token,
                                             @Query("realName") String realName,
                                             @Query("idNo") String idNo,
                                             @Query("userId") String userId,
                                             @Query("attachs[0].filePath") String idcard_front,
                                             @Query("attachs[0].certificateType") String idcard_front_type,
                                             @Query("attachs[1].filePath") String idcard_back,
                                             @Query("attachs[1].certificateType") String idcard_back_type,
                                             @Query("attachs[2].filePath") String hand_idcard,
                                             @Query("attachs[2].certificateType") String hand_idcard_type);

    /**
     * 企业认证
     * @param token
     * @param userId
     * @param companyName
     * @param licenseNo
     * @param personName
     * @param personPosition
     * @param personMobile
     * @param personEmail
     * @param idcard_front
     * @param idcard_front_type
     * @param idcard_back
     * @param idcard_back_type
     * @param hand_idcard
     * @param hand_idcard_type
     * @param license
     * @param license_type
     * @return
     */
    @POST("companyAuth")
    Observable<PApproveBean> approveCommit_c(@Header("token") String token,
                                             @Query("userId") String userId,
                                             @Query("companyName") String companyName,
                                             @Query("licenseNo") String licenseNo,
                                             @Query("personName") String personName,
                                             @Query("personPosition") String personPosition,
                                             @Query("personMobile") String personMobile,
                                             @Query("personEmail") String personEmail,

                                             @Query("attachs[0].filePath") String idcard_front,
                                             @Query("attachs[0].certificateType") String idcard_front_type,

                                             @Query("attachs[1].filePath") String idcard_back,
                                             @Query("attachs[1].certificateType") String idcard_back_type,

                                             @Query("attachs[2].filePath") String hand_idcard,
                                             @Query("attachs[2].certificateType") String hand_idcard_type,

                                             @Query("attachs[3].filePath") String license,
                                             @Query("attachs[3].certificateType") String license_type);

    /**
     * 获取首页房屋列表
     * @return
     */
    @POST("getHouseInfoList")
    Observable<HomeBean> getHouseList();

    @POST("getHouseInfoList")
    Observable<HomeBean> getHouseList(@Query("pageNum") String pageNum);

    /**
     * 获取房屋详情页数据
     * @param userId
     * @param houseId
     * @param auctionId
     * @return
     */
    @POST("getHouseInfoDetail")
    Observable<HouseInfoDetailBean> getHouseInfoDetail(@Query("userId") String userId ,
                                                       @Query("houseId") String houseId ,
                                                       @Query("auctionId") String auctionId );

    @POST("getHouseInfoDetail")
    Observable<HouseInfoDetailBean> getHouseInfoDetail(@Query("houseId") String houseId ,
                                                       @Query("auctionId") String auctionId );

    /**
     * 房产收藏
     * @param userId
     * @param houseId
     * @param auctionId
     * @return
     */
    @POST("savehouseCollection")
    Observable<CollectionBean> saveCollection(@Query("userId") String userId ,
                                              @Query("houseId") String houseId ,
                                              @Query("auctionId") String auctionId );

    /**
     * 取消房产收藏
     * @param id
     * @param auctionId
     * @return
     */
    @POST("clearHouseCollection")
    Observable<CollectionBean> centerCollection(@Query("id") String id ,
                                              @Query("auctionId") String auctionId );

    /**
     * 报名
     * @param userId
     * @param auctionId
     * @param realName
     * @param nationalId
     * @param region
     * @param street
     * @param depositId
     * @return
     */
    @POST("addAuctionSignRecord")
    Observable<SignBean> signRecord(@Query("userId") String userId ,
                                    @Query("auctionMeetingId") String auctionMeetingId,
                                    @Query("realName") String realName,
                                    @Query("nationalId") String nationalId,
                                    @Query("region") String region,
                                    @Query("street") String street,
                                    @Query("depositId") String depositId);

    /**
     * 出价
     * @param auctionId
     * @param userId
     * @param price
     * @param bidNo
     * @return
     */
    @POST("addAuctionRecord")
    Observable<SignBean> auctionRecord(@Query("auctionId") String auctionId ,
                                    @Query("userId") String userId,
                                    @Query("price") String price,
                                    @Query("bidNo") String bidNo);

    /**
     * 获取收藏列表
     * @param userId
     * @return
     */
    @POST("getUserCollectionList")
    Observable<CollectionListBean> getCollectList(@Query("userId") String userId);

    @POST("getUserCollectionList")
    Observable<CollectionListBean> getCollectList(@Query("userId") String userId,
                                                  @Query("pageNum") String pageNum);

    /**
     * 获取报名列表
     * @param userId
     * @return
     */
    @POST("getUserAuctionSignRecordList")
    Observable<AppliedListBean> getAppliedList(@Query("userId") String userId);

    @POST("getUserAuctionSignRecordList")
    Observable<AppliedListBean> getAppliedList(@Query("userId") String userId,
                                                  @Query("pageNum") String pageNum);

    /**
     * 获取已拍列表
     * @param userId
     * @return
     */
    @POST("getUserAuctionResultList")
    Observable<TakenListBean> getResultList(@Query("userId") String userId);

    @POST("getUserAuctionResultList")
    Observable<TakenListBean> getResultList(@Query("userId") String userId,
                                            @Query("pageNum") String pageNum);


    /**
     * 获取所有押金列表
     * @param userId
     * @return
     */
    @POST("getAuctionDepositAllList")
    Observable<DepositBean> getDepositList(@Query("userId") String userId);

    /**
     * 押金详情列表
     * @param depositId
     * @return
     */
    @POST("getDepositAndHouse")
    Observable<DepositDetailedBean> getDepositDetailedList(@Query("depositId") String depositId);

    @POST("getDepositAndHouse")
    Observable<DepositDetailedBean> getDepositDetailedList(@Query("depositId") String depositId,
                                                           @Query("pageNum") String pageNum );

    /**
     * 获取拍卖会列表
     * @param depositId
     * @param pageNum
     * @return
     */
    @POST("getMeetingIncludeHouseList")
    Observable<MeetingListBean> getMeetingList(@Query("auctionMeetingId") String auctionMeetingId);

    /**
     * 获取可用押金列表
     * @param auctionMeetingId
     * @return
     */
    @POST("getAuctionDepositList")
    Observable<NeedDepositBean> getNeedDepositList(@Query("userId") String userId,
                                                   @Query("regionId") String regionId,
                                                   @Query("amount") String amount);

    /**
     * 获取出价列表
     * @param auctionId
     * @return
     */
    @POST("getAuctionRecordList")
    Observable<BuyListBean> getBuyList(@Query("auctionId") String auctionId);

    @POST("getAuctionRecordList")
    Observable<BuyListBean> getBuyList(@Query("auctionId") String auctionId,
                                       @Query("pageNum") String pageNum);


    /**
     * 获取往期拍卖列表
     * @return
     */
    @POST("getAuctionResultList")
    Observable<PassAuctionListBean> getPassList();

    @POST("getAuctionResultList")
    Observable<PassAuctionListBean> getPassList(@Query("auctionId") String auctionId);


    /**
     * 获取认证状态
     * @param userId
     * @return
     */
    @POST("authStatus")
    Observable<AuthStatusBean> getAuthStatus(@Query("userId") String userId);

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @POST("getUserInfo")
    Observable<UserMessageBean> getUserMessage(@Query("userId") String userId);


    /**
     * 获取房屋点击量
     * @param houseId
     * @return
     */
    @POST("getUserInfo")
    Observable<HousePvBean> getHousePv(@Query("houseId") String houseId);
}






