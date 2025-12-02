package com.aiden.service;


import com.aiden.dto.FocusItemDTO;
import com.aiden.dto.FocusItemQueryDTO;
import com.aiden.dto.FocusItemResponseDTO;
import com.aiden.dto.PageResult;

/**
 * 专注项服务接口（原生MyBatis）
 */
public interface FocusItemService {

    /**
     * 新增专注项
     */
    Boolean addFocusItem(FocusItemDTO focusItemDTO);

    /**
     * 编辑专注项
     */
    Boolean updateFocusItem(FocusItemDTO focusItemDTO);

    /**
     * 删除专注项（逻辑删除）
     */
    Boolean deleteFocusItem(Long id);

    /**
     * 根据ID查询专注项详情
     */
    FocusItemResponseDTO getFocusItemById(Long id);

    /**
     * 分页查询专注项列表
     */
    PageResult<FocusItemResponseDTO> queryFocusItemPage(FocusItemQueryDTO queryDTO);
}
