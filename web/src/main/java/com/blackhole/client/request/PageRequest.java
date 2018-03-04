package com.blackhole.client.request;

/**
 * Created by 张钟 on 2017/7/12.
 */
public class PageRequest {

    /** 分页大小 **/
    protected int pageSize = 20;

    /** 页码 **/
    protected int currentPage = 1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
