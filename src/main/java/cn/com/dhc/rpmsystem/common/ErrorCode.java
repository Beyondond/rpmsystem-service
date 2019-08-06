package cn.com.dhc.rpmsystem.common;

/**
 * 异常枚举常量
 * @author zss
 * @date 2019-08-06
 */
public enum ErrorCode {

    ERROR("500", "系统异常"),
    DATA_NOT_EXISTS("400", "数据不存在");

    private String code;
    private String msg;

    ErrorCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
