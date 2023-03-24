package com.shanhai.springbootinittemplate.common;

import com.shanhai.springbootinittemplate.constant.PageConstant;

import java.io.Serializable;

/**
 * 分页查询时的参数
 *
 * @author shanghai
 * @version 1.0
 * @since 2023/3/24 16:58
 */
public class PageRequest <T> implements Serializable {
    /**
     * 当前页号
     */
    private long current = 1;

    /**
     * 页面大小
     */
    private long pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序（默认升序）
     */
    private String sortOrder = PageConstant.SORT_ORDER_ASC;
}
