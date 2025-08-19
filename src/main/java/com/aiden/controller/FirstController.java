package com.aiden.controller;

import com.aiden.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Tag(name = "用户管理", description = "用户相关操作API")
public class FirstController {

    @Autowired
    private UserService userService;

    @GetMapping("/first")
    @ApiResponse(responseCode = "200", description = "成功获取用户")
    @ApiResponse(responseCode = "404", description = "用户不存在")
    public String getUser(String userId) {
        return userService.getUser(userId);
    }
}
