package com.winter.business.page;

import lombok.Data;

import java.io.Serializable;


/**
 * @author wdd
 */
@Data
public class Pager<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 每页显示
     */
    private int limit = 10;

    /**
     * 页码
     */
    private int pageNo = 1;

    /**
     * 下标
     */
    private int offset = 0;

    private T condition;

    private String sortName;

    private String sortOrder;

    public void setPageNo(int pageNo) {
        if (pageNo > 0) {
            this.pageNo = pageNo;
            recalcOffset();
        }
    }

    private void recalcOffset() {
        if (pageNo > 0 && offset == 0) {
            offset = (pageNo - 1) * limit;
        }
    }

    public void setLimit(int limit) {
        if (limit > 0) {
            this.limit = limit;
            recalcOffset();
        }
    }

}

