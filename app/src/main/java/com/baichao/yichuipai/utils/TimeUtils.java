package com.baichao.yichuipai.utils;

import android.content.Context;

import com.baichao.yichuipai.fragment.presenter.MyPresenterImpl;

/**
 * Created by pll on 2017/6/5.
 */

public class TimeUtils {
    public static String getTime(){
        long time = System.currentTimeMillis();
        String str = String.valueOf(time/1000);
        return str;
    }

    public static boolean tokenIsPast(Context context, MyPresenterImpl presenter){
        if(ACache.get(context).getAsString("token_past_time")!=null &&
                ACache.get(context).getAsString("token_past_time").equals("")!=true){
            //判断token是否过期，过期重新获取
            String endTime = ACache.get(context).getAsString("token_past_time");
            String currentTime = TimeUtils.getTime();
            String token = ACache.get(context).getAsString("token");
            if(Integer.parseInt(currentTime)>Integer.parseInt(endTime)){
                //说明过期
                presenter.refreshToken(token);
            }
            return true;
        }else {
            return false;
        }
    }

    public static String getToken(Context context){
        String token = "";
        if(ACache.get(context).getAsString("token")!=null && ACache.get(context).getAsString("token").equals("")!=true){
            token = ACache.get(context).getAsString("token");
        }
        return token;
    }

    public static String getId(Context context){
        String userId = "";
        if(ACache.get(context).getAsString("userId")!=null && ACache.get(context).getAsString("userId").equals("")!=true){
            userId = ACache.get(context).getAsString("userId");
        }
        return userId;
    }
}
