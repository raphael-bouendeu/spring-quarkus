package com.itbcafrica.springboot.microservice.spring.repository;

import com.itbcafrica.springboot.microservice.spring.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestEntity, Long> {}
