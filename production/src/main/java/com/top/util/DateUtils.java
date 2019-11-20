package com.top.util;

/**
 * @author super.vae
 * @description: TODO
 * @date 2018/11/13  20:05
 */
public class DateUtils {

    public static String weekConvert(int weekDay) {
        String str = "";
        switch (weekDay) {
            case 1:
                str = "周一";
                break;
            case 2:
                str = "周二";
                break;
            case 3:
                str = "周三";
                break;
            case 4:
                str = "周四";
                break;
            case 5:
                str = "周五";
                break;
            case 6:
                str = "周六";
                break;
            case 7:
                str = "周日";
                break;
            default:
                break;
        }
        return str;
    }

}
