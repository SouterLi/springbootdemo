package com.aiden.dto;

import lombok.Data;

import java.util.List;

/**
 * 分页结果封装类
 */
@Data
public class PageResult<T> {
    /**
     * 总条数
     */
    private int total;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 当前页数据
     */
    private List<T> list;

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 页大小
     */
    private Integer pageSize;

    public PageResult(int total, Integer pageNum, Integer pageSize, List<T> list) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = (int) Math.ceil((double) total / pageSize);
        this.list = list;
    }
}
