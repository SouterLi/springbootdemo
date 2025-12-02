package com.aiden.controller;

import com.aiden.dto.FocusItemDTO;
import com.aiden.dto.FocusItemQueryDTO;
import com.aiden.dto.FocusItemResponseDTO;
import com.aiden.dto.PageResult;
import com.aiden.service.FocusItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 专注项控制器（原生MyBatis）
 */
@RestController
@RequestMapping("/focus-item")
public class FocusItemController {

    @Autowired
    private FocusItemService focusItemService;

    /**
     * 新增专注项
     */
    @PostMapping
    public ResponseEntity<Boolean> addFocusItem(@Validated @RequestBody FocusItemDTO focusItemDTO) {
        Boolean result = focusItemService.addFocusItem(focusItemDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * 编辑专注项
     */
    @PutMapping
    public ResponseEntity<Boolean> updateFocusItem(@Validated @RequestBody FocusItemDTO focusItemDTO) {
        Boolean result = focusItemService.updateFocusItem(focusItemDTO);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除专注项
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteFocusItem(@PathVariable Long id) {
        Boolean result = focusItemService.deleteFocusItem(id);
        return ResponseEntity.ok(result);
    }

    /**
     * 根据ID查询专注项详情
     */
    @GetMapping("/{id}")
    public ResponseEntity<FocusItemResponseDTO> getFocusItemById(@PathVariable Long id) {
        FocusItemResponseDTO responseDTO = focusItemService.getFocusItemById(id);
        return ResponseEntity.ok(responseDTO);
    }

    /**
     * 分页查询专注项列表
     */
    @GetMapping("/page")
    public ResponseEntity<PageResult<FocusItemResponseDTO>> queryFocusItemPage(FocusItemQueryDTO queryDTO) {
        PageResult<FocusItemResponseDTO> pageResult = focusItemService.queryFocusItemPage(queryDTO);
        return ResponseEntity.ok(pageResult);
    }
}
