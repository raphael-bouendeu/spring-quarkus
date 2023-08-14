package com.itbcafrica.microservice.quarkus.repository;

import com.itbcafrica.microservice.quarkus.entity.RoomEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RoomRepository implements PanacheRepository<RoomEntity>{
}
