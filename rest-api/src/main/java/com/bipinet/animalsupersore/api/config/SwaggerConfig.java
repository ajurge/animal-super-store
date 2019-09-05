package com.bipinet.animalsupersore.api.config;

import static com.google.common.collect.Sets.newHashSet;

import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  @Bean
  public Docket swagger() {
    return new Docket(DocumentationType.SWAGGER_2)
        .ignoredParameterTypes(ResponseEntity.class, File.class, Resource.class, InputStream.class)
        .useDefaultResponseMessages(false)
        .apiInfo(apiInfo())
        .protocols(newHashSet("http"))
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.bipinet.animalsupersore.api.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
        "Animal Super Store",
        "Description of Animal Super Store.",
        "1",
        "Terms of service",
        new Contact("Audrius Jurgelionis", null, null),
        "License of Animal Super Store", null, Collections.emptyList());
  }

}
