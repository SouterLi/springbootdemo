package com.aiden.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 专注项响应DTO
 */
@Data
public class FocusItemResponseDTO {

    /**
     * 专注项ID
     */
    private Long id;

    /**
     * 所属用户ID
     */
    private Long userId;

    /**
     * 专注名称
     */
    private String name;

    /**
     * 专注时长（分钟）
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
     * 排序优先级
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}