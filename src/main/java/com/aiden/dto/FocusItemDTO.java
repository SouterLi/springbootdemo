package com.aiden.dto;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 专注项新增/编辑请求DTO
 */
@Data
public class FocusItemDTO {

    /**
     * 专注项ID（编辑时必填）
     */
    private Long id;

    /**
     * 所属用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /**
     * 专注名称
     */
    @NotBlank(message = "专注名称不能为空")
    @Size(max = 100, message = "专注名称长度不能超过100个字符")
    private String name;

    /**
     * 专注时长（分钟）
     */
    @NotNull(message = "专注时长不能为空")
    @Min(value = 1, message = "专注时长不能小于1分钟")
    private Integer duration;

    /**
     * 倒计时背景图URL
     */
    @Size(max = 255, message = "背景图URL长度不能超过255个字符")
    private String bgUrl;

    /**
     * 倒计时BGM URL
     */
    @Size(max = 255, message = "BGM URL长度不能超过255个字符")
    private String bgmUrl;

    /**
     * 排序优先级
     */
    private Integer sort;
}