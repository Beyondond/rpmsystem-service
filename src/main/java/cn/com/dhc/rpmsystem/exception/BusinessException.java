package cn.com.dhc.rpmsystem.exception;

import cn.com.dhc.rpmsystem.common.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhouyongzhou
 * @description 自定义业务异常处理
 * @date 2019/7/30
 */
public class BusinessException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(BusinessException.class);
    private String errorCode;
    private String businessMsg;

    public BusinessException(String errorCode, String businessMsg) {
        super();
        this.errorCode = errorCode;
        this.businessMsg = businessMsg;
        logger.info(this.toString());
    }

    public BusinessException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode.getCode();
        this.businessMsg = errorCode.getMsg();
        logger.info(this.toString());
    }

    public BusinessException(String businessMsg) {
        super();
        this.errorCode = "";
        this.businessMsg = businessMsg;
        logger.info(this.toString());
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getBusinessMsg() {
        return businessMsg;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setBusinessMsg(String businessMsg) {
        this.businessMsg = businessMsg;
    }

    @Override
    public String toString() {
        return "Error Code: " + errorCode +
                "; Error Cause: " + businessMsg;
    }
}
