package com.davioooh.rubricatelefonica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RubricaTelefonicaApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(RubricaTelefonicaApplication.class, args);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry
      .addViewController("/")
      .setViewName("redirect:/contacts");
  }

}