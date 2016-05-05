package com.lhy.blog.exception;

import com.lhy.blog.dict.ErrorCode;

/**
 * Created by lhy on 16/5/5.
 */
public class BusinessException extends RuntimeException {

    private String message;
    private ErrorCode errorCode = ErrorCode.BAD_REQUEST;

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(String message, ErrorCode errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
