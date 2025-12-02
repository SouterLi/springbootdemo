package com.aiden.service.impl;

import com.aiden.dto.FocusItemDTO;
import com.aiden.dto.FocusItemQueryDTO;
import com.aiden.dto.FocusItemResponseDTO;
import com.aiden.dto.PageResult;
import com.aiden.entity.FocusItem;
import com.aiden.mapper.FocusItemMapper;
import com.aiden.service.FocusItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import java.util.List;

/**
 * 专注项服务实现类（原生MyBatis）
 */
@Service
public class FocusItemServiceImpl implements FocusItemService {

    @Autowired
    private FocusItemMapper focusItemMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addFocusItem(FocusItemDTO focusItemDTO) {
        // 校验用户+名称唯一性
        int count = focusItemMapper.countByUserIdAndName(
                focusItemDTO.getUserId(), focusItemDTO.getName(), 0L); // excludeId=0 表示不排除任何记录
        Assert.isTrue(count == 0, "该用户已存在同名的专注项");

        FocusItem focusItem = new FocusItem();
        BeanUtils.copyProperties(focusItemDTO, focusItem);
        focusItem.setIsDelete(0); // 确保未删除
        if (focusItem.getSort() == null) {
            focusItem.setSort(0); // 默认排序值
        }
        return focusItemMapper.insert(focusItem) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateFocusItem(FocusItemDTO focusItemDTO) {
        Assert.notNull(focusItemDTO.getId(), "专注项ID不能为空");

        // 校验用户+名称唯一性（排除自身）
        int count = focusItemMapper.countByUserIdAndName(
                focusItemDTO.getUserId(), focusItemDTO.getName(), focusItemDTO.getId());
        Assert.isTrue(count == 0, "该用户已存在同名的专注项");

        FocusItem focusItem = new FocusItem();
        BeanUtils.copyProperties(focusItemDTO, focusItem);
        return focusItemMapper.update(focusItem) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteFocusItem(Long id) {
        Assert.notNull(id, "专注项ID不能为空");
        // 先校验记录是否存在且未删除
        FocusItem focusItem = focusItemMapper.selectById(id);
        Assert.notNull(focusItem, "专注项不存在或已删除");
        return focusItemMapper.deleteById(id) > 0;
    }

    @Override
    public FocusItemResponseDTO getFocusItemById(Long id) {
        Assert.notNull(id, "专注项ID不能为空");
        FocusItem focusItem = focusItemMapper.selectById(id);
        if (focusItem == null) {
            return null;
        }
        FocusItemResponseDTO responseDTO = new FocusItemResponseDTO();
        BeanUtils.copyProperties(focusItem, responseDTO);
        return responseDTO;
    }

    @Override
    public PageResult<FocusItemResponseDTO> queryFocusItemPage(FocusItemQueryDTO queryDTO) {
        // 1. 查询总条数
        int total = focusItemMapper.countByQuery(queryDTO);
        if (total == 0) {
            return new PageResult<>(0, queryDTO.getPageNum(), queryDTO.getPageSize(), null);
        }
        // 2. 查询当前页数据
        List<FocusItemResponseDTO> list = focusItemMapper.selectPageByQuery(queryDTO);
        // 3. 封装分页结果
        return new PageResult<>(total, queryDTO.getPageNum(), queryDTO.getPageSize(), list);
    }
}
