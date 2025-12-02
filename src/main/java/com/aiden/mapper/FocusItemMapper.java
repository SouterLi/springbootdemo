package com.aiden.mapper;

import com.aiden.dto.FocusItemQueryDTO;
import com.aiden.dto.FocusItemResponseDTO;
import com.aiden.entity.FocusItem;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 专注项Mapper接口（原生MyBatis）
 */
@Repository
public interface FocusItemMapper {

    /**
     * 新增专注项
     */
    @Insert("INSERT INTO focus_item (user_id, name, duration, bg_url, bgm_url, sort, is_delete, create_time, update_time) " +
            "VALUES (#{userId}, #{name}, #{duration}, #{bgUrl}, #{bgmUrl}, #{sort}, 0, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id") // 回填自增ID
    int insert(FocusItem focusItem);

    /**
     * 编辑专注项
     */
    @Update("UPDATE focus_item SET " +
            "user_id = #{userId}, name = #{name}, duration = #{duration}, bg_url = #{bgUrl}, bgm_url = #{bgmUrl}, " +
            "sort = #{sort}, update_time = NOW() " +
            "WHERE id = #{id} AND is_delete = 0")
    int update(FocusItem focusItem);

    /**
     * 逻辑删除专注项
     */
    @Update("UPDATE focus_item SET is_delete = 1, update_time = NOW() WHERE id = #{id}")
    int deleteById(Long id);

    /**
     * 根据ID查询（未删除）
     */
    @Select("SELECT * FROM focus_item WHERE id = #{id} AND is_delete = 0")
    FocusItem selectById(Long id);

    /**
     * 校验用户+名称是否唯一（排除自身）
     */
    @Select("SELECT COUNT(*) FROM focus_item WHERE user_id = #{userId} AND name = #{name} " +
            "AND is_delete = 0 AND id != #{excludeId}")
    int countByUserIdAndName(@Param("userId") Long userId, @Param("name") String name, @Param("excludeId") Long excludeId);

    /**
     * 分页查询-查询总条数
     */
    int countByQuery(FocusItemQueryDTO query);

    /**
     * 分页查询-查询当前页数据
     */
    List<FocusItemResponseDTO> selectPageByQuery(@Param("query") FocusItemQueryDTO query);
}