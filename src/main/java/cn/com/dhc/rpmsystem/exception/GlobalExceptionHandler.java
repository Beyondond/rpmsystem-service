package cn.com.dhc.rpmsystem.exception;

import cn.com.dhc.rpmsystem.common.ErrorCode;
import cn.com.dhc.rpmsystem.entity.ResultEntity;
import cn.com.dhc.rpmsystem.utils.ResultUtils;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现全局的错误处理
 * @author zss
 * @date 2019-08-06
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    //自定义异常
    @ExceptionHandler(Exception.class)
    public ResultEntity handleException(Exception e, HttpServletRequest request, HttpServletResponse response){

        logger.error("请求：{}发生异常：{}", request.getRequestURI(), e);

        ResultEntity result = null;
        if (e instanceof BusinessException) {
            result = ResultUtils.failure( ((BusinessException) e).getBusinessMsg(), Integer.valueOf(((BusinessException) e).getErrorCode()));
        } else {
            result = ResultUtils.failure(ErrorCode.ERROR.getMsg(), Integer.valueOf(ErrorCode.ERROR.getCode()));
        }

        return result;
    }

}
