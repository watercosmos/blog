package com.lhy.blog.dict;

/**
 * Created by lhy on 16/5/5.
 */
public enum ErrorCode {
    BAD_REQUEST(400, "服务器未能理解请求"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "无法找到被请求的内容"),
    INTERNAL_SERVER_ERROR(500, "服务器遇到不可预知的情况");

    private Integer index;
    private String name;

    ErrorCode(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}