package com.aiden.dto;

import lombok.Data;
import java.util.List;

/**
 * 专注项查询条件DTO
 */
@Data
public class FocusItemQueryDTO {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 专注名称（模糊查询）
     */
    private String name;

    /**
     * 排序字段（默认update_time）
     */
    private String sortField;

    /**
     * 排序方式（asc/desc，默认desc）
     */
    private String sortOrder;

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 页大小
     */
    private Integer pageSize = 10;

    /**
     * 计算分页起始位置（MyBatis分页用）
     */
    public Integer getStartRow() {
        return (pageNum - 1) * pageSize;
    }
}

