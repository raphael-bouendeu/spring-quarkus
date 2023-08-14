package com.itbcafrica.springboot.microservice.spring.webservice;

import com.itbcafrica.springboot.microservice.spring.model.GreetingResponse;
import com.itbcafrica.springboot.microservice.spring.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

  @Autowired GreetingService service;

  @GetMapping
  public GreetingResponse getGreeting() {

    return service.getGreeting();
  }
}
