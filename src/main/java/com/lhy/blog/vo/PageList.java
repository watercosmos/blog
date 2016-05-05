package com.lhy.blog.vo;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lhy on 16/5/5.
 */
public class PageList implements Serializable {
    private Collection pageList;
    private Page page;

    public PageList() {
        this.pageList = Lists.newArrayList();
        this.page = new Page();
    }

    public PageList(Collection pageList) {
        this.pageList = pageList;
        this.page = new Page();
        if (null != this.pageList) {
            this.page.setTotalCount(this.pageList.size());
        }
    }

    public PageList(Collection pageList, Page page) {
        this.pageList = pageList;
        this.page = page;
    }

    public Collection getPageList() {
        return pageList;
    }

    public void setPageList(Collection pageList) {
        this.pageList = pageList;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}