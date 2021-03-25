package com.davioooh.rubricatelefonica;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicResourcesController {

  @GetMapping("/login")
  public String loginPage(Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      return "redirect:/contacts";
    }
    return "login";
  }

  @GetMapping("/")
  public String home() {
    return "home";
  }

}