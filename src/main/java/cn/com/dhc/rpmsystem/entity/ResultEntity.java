package cn.com.dhc.rpmsystem.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author zhouyongzhou
 * @description 返回结果封装
 * @date 2019/7/30
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResultEntity<T> {
    private int code;
    private String message;
    private T data;

    public ResultEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
