package com.winter.business.page;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author wdd
 */
@Data
public class PagerResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 每页显示
     */
    private int limit = 10;

    /**
     * 页码
     */
    private int offset = 0;


    private List<T> rows = Collections.emptyList();

    /**
     * 总条数
     */
    private int total;

    /**
     * 调整URL
     */
    private String toUrl;


    public void setLimit(int limit) {
        if (limit > 0) {
            this.limit = limit;
        }
    }

    public void setOffset(int offset) {
        if (offset < 0) {
            offset = 0;
        }
        this.offset = offset;
    }



    public int getPageCount() {
        return getTotal() % getLimit() == 0 ? getTotal() / getLimit() : getTotal() / getLimit() + 1;
    }

    public int getPageNo() {
        return getOffset() % getLimit() == 0 ? getOffset() / getLimit() + 1 : getOffset() / getLimit();
    }


    public <K> PagerResult<K> convertPagerResult(Converter<T, K> converter) {
        List<K> kList = new ArrayList<K>(rows.size());
        for (T entity : getRows()) {
            kList.add(converter.convert(entity));
        }
        PagerResult<K> prK = new PagerResult<K>();
        prK.setLimit(limit);
        prK.setToUrl(toUrl);
        prK.setTotal(getTotal());
        prK.setOffset(offset);
        prK.setRows(kList);
        return prK;
    }

    public static interface Converter<T, K> {
        public K convert(T entity);
    }

}

