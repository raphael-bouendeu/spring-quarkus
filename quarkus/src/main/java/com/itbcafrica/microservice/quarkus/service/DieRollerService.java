package com.itbcafrica.microservice.quarkus.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DieRollerService {
  @ConfigProperty(name = "die.sides")
  private int sides;

  public int getRoll() {
    return (int) ((Math.random() * sides) + 1);
  }
}
