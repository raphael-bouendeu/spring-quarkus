package com.itbcafrica.microservice.quarkus.service;


import com.itbcafrica.microservice.quarkus.entity.GuestEntity;
import com.itbcafrica.microservice.quarkus.entity.RoomEntity;
import com.itbcafrica.microservice.quarkus.model.GreetingResponse;
import com.itbcafrica.microservice.quarkus.repository.GuestRepository;
import com.itbcafrica.microservice.quarkus.repository.RoomRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GreetingService{
  @ConfigProperty(name="greeting.text")
  private String greeting;

  private  final DieRollerService dieRollerService;
  private final RoomRepository roomRepository;
  private final GuestRepository guestRepository;
  public GreetingService(DieRollerService dieRollerService, RoomRepository roomRepository, GuestRepository guestRepository){
    this.dieRollerService=dieRollerService;
    this.roomRepository=roomRepository;
    this.guestRepository=guestRepository;
  }

  public GreetingResponse getGreeting() {
    GreetingResponse greetingResponse = new GreetingResponse();
    greetingResponse.setGreeting(greeting);
    greetingResponse.setDieRoll(dieRollerService.getRoll());
    List<RoomEntity> entityPanacheQuery=roomRepository.listAll();
    List<String> roomNumbers =
            entityPanacheQuery.stream().map(RoomEntity::getRoomNumber).collect(Collectors.toList());
    greetingResponse.setRoomNumbers(roomNumbers);
    List<GuestEntity> guestEntities = guestRepository.listAll();
    List<String> stringList=guestEntities.stream().map(GuestEntity::getEmailAddress).collect(Collectors.toList());
   greetingResponse.setEmails(stringList);
    return greetingResponse;
  }
}
