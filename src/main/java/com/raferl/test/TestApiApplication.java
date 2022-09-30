package com.raferl.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class TestApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestApiApplication.class, args);
  }
}
