package com.itbcafrica.springboot.microservice.spring.service;

import com.itbcafrica.springboot.microservice.spring.entity.GuestEntity;
import com.itbcafrica.springboot.microservice.spring.entity.RoomEntity;
import com.itbcafrica.springboot.microservice.spring.model.GreetingResponse;
import com.itbcafrica.springboot.microservice.spring.repository.GuestRepository;
import com.itbcafrica.springboot.microservice.spring.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreetingService {
  @Value("${greeting.text}")
  private String greeting;

  private final DieRollerService dieRollerService;
  private final RoomRepository roomRepository;
  private  final GuestRepository guestRepository;

  public GreetingService(DieRollerService dieRollerService, RoomRepository roomRepository, GuestRepository guestRepository) {
    this.dieRollerService = dieRollerService;
    this.roomRepository = roomRepository;
    this.guestRepository=guestRepository;
  }

  public GreetingResponse getGreeting() {
    GreetingResponse greetingResponse = new GreetingResponse();
    greetingResponse.setGreeting(greeting);
    greetingResponse.setDieRoll(dieRollerService.getRoll());
    List<RoomEntity> roomEntityList = roomRepository.findAll();
    List<GuestEntity>guestEntities= guestRepository.findAll();
    List<String> collectEmails=guestEntities.stream().map(GuestEntity::getEmailAddress).collect(Collectors.toList());
    List<String> roomNumbers =
        roomEntityList.stream().map(RoomEntity::getRoomNumber).collect(Collectors.toList());
    greetingResponse.setEmails( collectEmails);
    greetingResponse.setRoomNumbers(roomNumbers);
    return greetingResponse;
  }
}
