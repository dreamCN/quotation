package com.wlxk.quotation.common;

/**
 * @author: 鼠行止
 * @date: 2019/9/14
 */
public class BasePage {
    private static Integer DEFAULT_PAGE_SIZE = 20;
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalRecord;

    public BasePage() {
    }

    public Integer getPageSize() {
        return this.pageSize != null && this.pageSize >= 1 ? this.pageSize : DEFAULT_PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }else {
            this.pageSize = pageSize;
        }
    }

    public Integer getCurrentPage() {
        return this.currentPage != null && this.currentPage >= 1 ? this.currentPage : 1;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageTotal() {
        if (this.totalRecord == null) {
            return 0;
        } else {
            int tp = this.totalRecord / this.getPageSize();
            if (this.totalRecord % this.getPageSize() > 0) {
                ++tp;
            }

            return tp;
        }
    }

    public Integer getTotalRecord() {
        return this.totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getOffset() {
        return (this.getCurrentPage() - 1) * this.getPageSize();
    }

}
