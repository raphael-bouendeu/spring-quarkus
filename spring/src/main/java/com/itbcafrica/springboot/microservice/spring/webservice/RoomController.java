package com.itbcafrica.springboot.microservice.spring.webservice;

import com.itbcafrica.springboot.microservice.spring.entity.RoomEntity;
import com.itbcafrica.springboot.microservice.spring.model.BadRequestException;
import com.itbcafrica.springboot.microservice.spring.model.NotFoundException;
import com.itbcafrica.springboot.microservice.spring.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {
  private final RoomRepository roomRepository;

  public RoomController(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @GetMapping
  public Iterable<RoomEntity> getRooms() {
    return roomRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RoomEntity addRoom(@RequestBody RoomEntity room) {
    return roomRepository.save(room);
  }

  @RequestMapping("/{id}")
  public RoomEntity getRoomById(@PathVariable(value = "id") long id) {
    Optional<RoomEntity> room = roomRepository.findById(id);
    if (room.isEmpty()) {
      throw new NotFoundException("room id " + id + " not found");
    }
    return room.get();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateRoom(@PathVariable(value = "id") long id, @RequestBody RoomEntity room) {
    if (room.getRoomId() != id) throw new BadRequestException("id mismatch on update");
    roomRepository.save(room);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.RESET_CONTENT)
  public void delete(@PathVariable(value = "id") long id) {
    roomRepository.deleteById(id);
  }
}
