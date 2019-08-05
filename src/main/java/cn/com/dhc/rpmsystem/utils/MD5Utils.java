package cn.com.dhc.rpmsystem.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhouyongzhou
 * @description MD5加密转换
 * @date 2019/8/1
 */
public class MD5Utils {

    /**
     * 转换成md5
     *
     * @param originalStr
     * @return
     */
    public static String string2MD5(String originalStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            LogUtils.error(MD5Utils.class, e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = originalStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

}
