package com.lhy.blog.model;

import com.google.common.collect.Maps;
import com.lhy.blog.dict.ErrorCode;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Map;

/**
 * Created by lhy on 16/5/5.
 */
public class Result<T> {
    public static final Integer SUCCESS = 1;
    public static final Integer FAILED = 0;

    private T data;
    private Integer status;


    public static <T> Builder<T> builder() {
        return new Builder<T>();
    }

    public static class Builder<T> {
        private T data;
        private Integer status;

        public Builder() {}

        public Result build() {
            Assert.notNull(status, "status不能为空");
            Assert.notNull(data, "data不能为空");
            Result<T> result = new Result<>();
            result.setData(data);
            result.setStatus(status);
            return result;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public Builder data(String message) {
            Map<String, String> map = Maps.newHashMap();
            map.put("message", message);
            this.data = (T) map;
            return this;
        }

        public Builder data(Collection pageList, Page page) {
            this.data = (T) new PageList(pageList, page);
            return this;
        }

        public Builder failed(ErrorCode errorCode, String message) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("errorCode", errorCode.getIndex());
            map.put("message", message);
            this.data = (T) map;
            this.status = FAILED;
            return this;
        }

        public Builder failed(ErrorCode errorCode) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("errorCode", errorCode.getIndex());
            map.put("message", errorCode.getName());
            this.data = (T) map;
            this.status = FAILED;
            return this;
        }

        public Builder success() {
            this.status = SUCCESS;
            return this;
        }

        public Builder failed() {
            this.status = FAILED;
            return this;
        }

    }

    public Result() {}

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
