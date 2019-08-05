package cn.com.dhc.rpmsystem.utils;

import cn.com.dhc.rpmsystem.common.Constants;
import cn.com.dhc.rpmsystem.entity.ResultEntity;

/**
 * @author zhouyongzhou
 * @description 返回结果封装
 * @date 2019/7/30
 */
public class ResultUtils {
    public static ResultEntity success(Object object) {
        ResultEntity entity = new ResultEntity(Constants.SUCCESS, Constants.VALUES.get(Constants.SUCCESS));
        entity.setData(object);
        return entity;
    }

    public static ResultEntity succcess() {
        ResultEntity entity = new ResultEntity(Constants.SUCCESS, Constants.VALUES.get(Constants.SUCCESS));
        return entity;
    }

    public static ResultEntity failure(String message, int code) {
        ResultEntity entity = new ResultEntity(code, message);
        return entity;
    }

    public static ResultEntity failure(int code) {
        ResultEntity entity = new ResultEntity(code, Constants.VALUES.get(code));
        return entity;
    }

    public static ResultEntity failure(String message) {
        ResultEntity entity = new ResultEntity(Constants.FAILURE, message);
        return entity;
    }

}
