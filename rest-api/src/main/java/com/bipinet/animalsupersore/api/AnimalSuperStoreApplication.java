package com.bipinet.animalsupersore.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan({"io.swagger", "com.bipinet"})
@SpringBootApplication
@EnableSwagger2
public class AnimalSuperStoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(AnimalSuperStoreApplication.class, args);
  }
}
