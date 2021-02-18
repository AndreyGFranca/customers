package com.github.andreygfranca.customermanager.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:customermanager.properties")
public class OpenAPIConfiguration {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .tags(
            new Tag("Customer", "Customer REST API"),
            new Tag("City", "City REST API")
        )
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.github.andreygfranca.customermanager"))
        .paths(PathSelectors.any())
        .build();
  }
}
