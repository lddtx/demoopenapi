package org.wj.prajumsook.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenApi配置类
 * 地址访问：http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customConfiguration() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Member API Docs")
                        .description("Sample REST API documentation"));
    }
}
