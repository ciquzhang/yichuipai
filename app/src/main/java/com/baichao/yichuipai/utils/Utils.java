package com.baichao.yichuipai.utils;

/**
 * Created by Administrator on 2017/6/15.
 */

public class Utils {
    public static String nullToString(Object object){
        if(object==null){
            return "";
        }else {
            return object + "";
        }
    }
}
