package com.itbcafrica.springboot.microservice.spring.repository;

import com.itbcafrica.springboot.microservice.spring.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {}
