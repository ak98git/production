package com.top.util;


import com.top.common.constant.BaseConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.SecureRandom;

/**
 * 加密，解密
 */
public class SecretUtil {
	
    public static final String AES = "AES";
    private static final Charset charset = Charset.forName(BaseConstants.SYS_UTF8_ENCODE);
    private static byte[] keyBytes = BaseConstants.DATA_SECRET_KEY.getBytes(charset);
    
    private final static Logger logger = LoggerFactory.getLogger(SecretUtil.class);
 
    /**
     * 数据加密
     * @param data 待加密数据字符串
     * @param key 加解密key
     * @return 加密后的字符串
     */
    public static String encryptAES(String data, String key) {
        try {
            if (StringUtils.isBlank(data) || StringUtils.isBlank(key)) {
                return null;
            }
            byte[] content = data.getBytes(BaseConstants.SYS_UTF8_ENCODE);
            KeyGenerator kgen = KeyGenerator.getInstance(AES);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(key.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, AES);
            //创建密码器
            Cipher cipher = Cipher.getInstance(AES);
            // 初始化
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] result = cipher.doFinal(content);
            return parseByte2HexStr(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    /**
     * 数据解密
     * @param data 已加密数据字符串
     * @param key 加解密key
     * @return 解密后的字符串
     */
    public static String decryptAES(String data, String key) {
        try {
            if (StringUtils.isBlank(data) || StringUtils.isBlank(key)) {
                return null;
            }
            byte[] content = parseHexStr2Byte(data);
            KeyGenerator kgen = KeyGenerator.getInstance(AES);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(key.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, AES);
            Cipher cipher = Cipher.getInstance(AES);// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, keySpec);// 初始化
            byte[] result = cipher.doFinal(content);
            return new String(result, BaseConstants.SYS_UTF8_ENCODE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 纯数字加密
     */
    public static String encodeNumb(String source, String key) {
    	byte[] array = source.getBytes(charset);
		for (int i = 0, size = array.length; i < size; i++) {
			for (byte keyBytes0 : keyBytes) {
				array[i] = (byte) (array[i] ^ keyBytes0);
			}
		}
        String encodeString = new String(array);
        logger.info("source={}, encode={}", source, encodeString);
        return encodeString;
    }

    /**
     * 纯数字解密
     */
    public static String decodeNumb(String encodeNumb, String key) {
    	byte[] encodeArray = encodeNumb.getBytes(charset);
		byte[] tmp = encodeArray;
		for (int i = 0, size = encodeArray.length; i < size; i++) {
			for (byte keyBytes0 : keyBytes) {
				encodeArray[i] = (byte) (tmp[i] ^ keyBytes0);
			}
		}
        String decodeString = new String(encodeArray);
        logger.info("source={}, encode={}", encodeNumb, decodeString);
        return decodeString;
    }

    /**
     * 将二进制转换成16进制
     * @return
     */
    private static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
 
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
    
    public static void main(String[]args){
    	String key = "13590386972";
		String json = "{\"agentCode\":\"13590386972\",\"bankCardNo\":\"5324580000000049\",\"bankType\":\"1051000\",\"certificateNo\":\"150429198606152126\",\"custCardCvv2\":\"248\",\"custCardValidDate\":\"1219\",\"endDate\":\"20200320\",\"holderName\":\"韦小宝\",\"mobileNo\":\"13525677809\",\"startDate\":\"20190318\"}\"";
		String enstring = SecretUtil.encryptAES(json, key);
		System.out.println(enstring);
		String destring = SecretUtil.decryptAES("eyJzbXNTZXEiOiIyMDE5MDMxODAwMzIxNjY4IiwiYWdlbnRPcmRlcklkIjoiMTkwMzE4MTAzMzI0MzU5MDAwMDAxMjcxMTg3ODYzIn0=", key);
		System.out.println(destring);
	}
}
