package com.aiden.mapper;

import com.aiden.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectById(Long userId);
}
