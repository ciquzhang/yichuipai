package com.baichao.yichuipai.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/14.
 */

public class DateUtil {
    private static SimpleDateFormat sf = null;

    /*获取系统时间 格式为："yyyy/MM/dd "*/
    public static String getCurrentDate() {
        Date d = new Date();
        sf = new SimpleDateFormat("yyyy年MM月dd日");
        return sf.format(d);
    }

    /*时间戳转换成字符窜*/
    public static String getDateToString(long time) {
//        String res;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
//        long lt = new Long(s);
//        Date date = new Date(lt);
//        res = simpleDateFormat.format(date);
//        return res;

        Date d = new Date(time);
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(d);
    }

    public static String getDateToShortString(long time) {
//        String res;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
//        long lt = new Long(s);
//        Date date = new Date(lt);
//        res = simpleDateFormat.format(date);
//        return res;

        Date d = new Date(time);
        sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(d);
    }

    /**
     * 直接获取时间戳
     * @return
     */
    public static String getTimeStamp() {
        String currentDate = getCurrentDate();
        sf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date();
        try{
            date = sf.parse(currentDate);
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(date.getTime());
    }
}
