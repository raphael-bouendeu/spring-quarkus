package com.itbcafrica.microservice.quarkus.model;

import java.util.List;

public class GreetingResponse {
  private String greeting;
  private int dieRoll;
  private List<String> roomNumbers;
  private List<String> emails;

  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }

  public List<String> getRoomNumbers() {
    return roomNumbers;
  }

  public void setRoomNumbers(List<String> roomNumbers) {
    this.roomNumbers = roomNumbers;
  }

  public int getDieRoll() {
    return dieRoll;
  }

  public void setDieRoll(int dieRoll) {
    this.dieRoll = dieRoll;
  }

  public String getGreeting() {
    return greeting;
  }

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }
}
