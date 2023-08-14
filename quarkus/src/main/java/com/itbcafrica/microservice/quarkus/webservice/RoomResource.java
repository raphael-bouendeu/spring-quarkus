package com.itbcafrica.microservice.quarkus.webservice;

import com.itbcafrica.microservice.quarkus.entity.RoomEntity;
import com.itbcafrica.microservice.quarkus.repository.RoomRepository;
import com.oracle.svm.core.annotate.Delete;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestPath;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rooms")
@Produces("application/json")
public class RoomResource {
  private final RoomRepository roomRepository;

  public RoomResource(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @GET
  @Consumes("application/json")
  public List<RoomEntity> getRooms() {
    return roomRepository.listAll();
  }

  @POST
  @Transactional
  @ResponseStatus(201)
  public RoomEntity addRoom(RoomEntity room) {

    roomRepository.persist(room);
    return room;
  }

  @GET
  @Path("/{id}")
  public RoomEntity getRoomById(@RestPath(value = "id") long id) {
    RoomEntity entity = roomRepository.findById(id);
    if (entity == null)
      throw new WebApplicationException(Response.status(404).entity(id + "doesn t exiist").build());
    return entity;
  }

  @PUT
  @Path("/{id}")
  @ResponseStatus(204)
  @Transactional
  public void update(@RestPath(value = "id") long id, RoomEntity room) {
    if (room.getRoomId() != id)
      throw new WebApplicationException(Response.status(400).entity(id + "doesn t match").build());
    RoomEntity roomEntity = roomRepository.findById(id);
    roomEntity.setRoomNumber(room.getRoomNumber());
    roomEntity.setBewInfo(room.getBewInfo());
    roomEntity.setName(room.getName());
    roomRepository.persist(roomEntity);
  }

  @Delete
  @Transactional
  @ResponseStatus(205)
  @Path("{id}")
  public void deleteRoom(@RestPath(value = "id") long id) {
    roomRepository.deleteById(id);
  }
}
