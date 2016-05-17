package com.lhy.blog.web;

import com.lhy.blog.dict.ErrorCode;
import com.lhy.blog.exception.BusinessException;
import com.lhy.blog.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lhy on 16/5/5.
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandlingController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(BusinessException.class)
    public Result businessExceptionHandler(Exception exception, HttpServletRequest request) {
        LOGGER.warn("Request: {} {} raised {}", request.getMethod(), request.getRequestURI(), exception);
        return Result.builder().failed(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage()).build();
    }

    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerExceptionHandler(Exception exception, HttpServletRequest request) {
        LOGGER.warn("Request: {} {} raised {}", request.getMethod(), request.getRequestURI(), exception);
        return Result.builder().failed(ErrorCode.BAD_REQUEST, exception.getMessage()).build();
    }
}
