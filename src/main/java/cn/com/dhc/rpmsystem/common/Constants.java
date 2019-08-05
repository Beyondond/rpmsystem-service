package cn.com.dhc.rpmsystem.common;

import java.util.HashMap;

/**
 * @author zhouyongzhou
 * @description 全局变量
 * @date 2019/7/31
 */
public class Constants {
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1000;

    public static HashMap<Integer,String> VALUES = new HashMap<>();

    static{
        VALUES.put(SUCCESS,"成功");
    }

}
