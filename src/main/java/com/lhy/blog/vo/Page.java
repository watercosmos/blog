package com.lhy.blog.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lhy on 16/5/5.
 */
public class Page implements Cloneable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Page.class);

    public static int DEFAULT_PAGE_SIZE = 20;

    public static int DEFAULT_PAGE_NO = 1;

    private int pageNo = DEFAULT_PAGE_NO;

    private int pageSize = DEFAULT_PAGE_SIZE;

    private int totalCount = 0;

    private int totalPageCount = 1;

    public Page() {}

    public Page(Integer pageNo) {
        this.pageNo = pageNo;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public Page(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public Page(Integer pageNo, Integer pageSize, Integer totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int page) {
        this.pageNo = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calculateTotalPageCount();
    }

    public int getTotalPageCount() {
        calculateTotalPageCount();
        return totalPageCount;
    }

    private void calculateTotalPageCount() {
        totalPageCount = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            totalPageCount++;
        }
        if (pageNo > totalPageCount) {
            pageNo = totalPageCount;
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
    }

    @Override
    public Object clone() {
        Object page = null;
        try {
            page = super.clone();
        } catch (CloneNotSupportedException e) {
            LOGGER.warn("Page clone(): {}", e);
        }
        return page;
    }
}
