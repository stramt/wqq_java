package com.family.wqq.exception;


import com.family.wqq.common.rsp.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName RRException
 * @Description 异常处理器
 * @Author hdp
 * @Date 2020/11/9 9:52
 * @Version 1.0
 **/
@RestControllerAdvice
public class RRExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RRException.class)
    public Result handleRRException(RRException e) {
        logger.error(e.getMessage());
        Result r = new Result();
        r.setCode(e.getCode());
        r.setMessage(e.getMessage());
        return r;
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return Result.ERROR();

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error("请求接口缺少必要参数", e);
        return Result.PARAM();
    }
}
