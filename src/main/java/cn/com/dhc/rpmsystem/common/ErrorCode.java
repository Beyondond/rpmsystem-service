package cn.com.dhc.rpmsystem.common;

import lombok.Getter;

/**
 * 异常枚举常量
 * @author zss
 * @date 2019-08-06
 */
@Getter
public enum ErrorCode {

    ERROR("500", "系统异常"),
    DATA_NOT_EXISTS("400", "数据不存在");

    private String code;
    private String msg;

    ErrorCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
