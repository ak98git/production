package com.top.util;

/**
 * @author Super.vae
 * @description 号码部分隐藏
 * @date 2018/11/13  14:14
 */
public class EncryptorUtils {

    /**
     * 身份证号码隐藏
     * @param idNumber
     * @return
     */
    public static String hidIdNumber(String idNumber){
        try {
            return idNumber.replace(idNumber.substring(6,15),"*********");
        }catch (Exception e){
            return "";
        }
    }

    /**
     * 电话号码隐藏
     * @param phoneNumber
     * @return
     */
    public static String hidPhoneNumber(String phoneNumber){
        try {
            return phoneNumber.replace(phoneNumber.substring(3,7),"****");
        }catch (Exception ex){
            return "";
        }
    }

    /**
     * 姓名隐藏
     * @param hidUserName
     * @return
     */
    public static String hidUserName(String hidUserName){
        try {
            return hidUserName.replace(hidUserName.substring(1,2),"*");
        }catch (Exception ex){
            return "";
        }
    }

}
