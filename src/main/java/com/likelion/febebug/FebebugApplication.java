package com.likelion.febebug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FebebugApplication {

  public static void main(String[] args) {
    SpringApplication.run(FebebugApplication.class, args);
  }

}
