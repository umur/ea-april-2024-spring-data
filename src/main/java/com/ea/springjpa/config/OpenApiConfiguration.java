package com.ea.springjpa.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI springOpenAPI(@Value("${spring.application.name}") String appName,
                                 @Value("${spring.application.url}") String appUrl) {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(new Info()
                        .title(appName + " API"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth", Arrays.asList("read", "write")))
                .addServersItem(new Server().url(appUrl));
    }

}