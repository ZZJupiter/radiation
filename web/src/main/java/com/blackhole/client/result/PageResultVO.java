package com.blackhole.client.result;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;


/**
 * @author 张钟
 * @date 2017/12/7
 */
public class PageResultVO<T> extends ResultVO {

    private Integer total;

    private Integer totalPage;

    private Integer pageSize;

    private Integer currentPage;

    public PageResultVO(boolean isSuccess, int code, String message) {
        super(isSuccess, code, message);
    }

    public PageResultVO(Page page, boolean copyResult){
        super(true,200,"操作成功!");
        this.total = page.getTotal();
        this.totalPage = page.getPages();
        this.pageSize = page.getSize();
        this.currentPage = page.getOffset();
        if(copyResult){
            this.setResult(page.getRecords());
        }
    }

    public PageResultVO(Page page, List<T> data) {
        super(true,200,"操作成功!");
        this.total = page.getTotal();
        this.totalPage = page.getPages();
        this.pageSize = page.getSize();
        this.currentPage = page.getOffset();
        this.setResult(data);
    }



    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
