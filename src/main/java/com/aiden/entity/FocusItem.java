package com.aiden.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 专注项模板表（番茄钟定义）
 */
@Data
public class FocusItem {

    /**
     * 专注项ID
     */
    private Long id;

    /**
     * 所属用户ID
     */
    private Long userId;

    /**
     * 专注名称（如“编程”）
     */
    private String name;

    /**
     * 专注时长（分钟，≥1）
     */
    private Integer duration;

    /**
     * 倒计时背景图URL
     */
    private String bgUrl;

    /**
     * 倒计时BGM URL
     */
    private String bgmUrl;

    /**
     * 排序优先级（值越小越靠前）
     */
    private Integer sort;

    /**
     * 逻辑删除（0-未删，1-已删）
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}