package com.github.andreygfranca.customermanager.bootloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.github.andreygfranca.customermanager"})
@EnableJpaRepositories("com.github.andreygfranca.customermanager.adapter.persistence")
@EntityScan("com.github.andreygfranca.customermanager.core.domain")
public class CustomerManagerApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(CustomerManagerApplication.class, args);
  }
  
}
