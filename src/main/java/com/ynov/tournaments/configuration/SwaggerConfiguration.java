package com.ynov.tournaments.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public OpenAPI openAPI() {

    Info info = new Info()
        .title("API Web services")
        .version("1.0")
        .description("This API exposes endpoints to board games.");

    return new OpenAPI().info(info);
  }
}