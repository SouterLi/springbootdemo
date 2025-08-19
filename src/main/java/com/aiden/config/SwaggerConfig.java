package com.aiden.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API 文档",
                version = "1.0",
                description = "项目 API 文档"
        )
)
public class SwaggerConfig {
    // 可以添加更多自定义配置
}