package com.itbcafrica.microservice.quarkus.entity;

import javax.persistence.*;

@Entity
@Table(name="ROOM")
public class RoomEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ROOM_ID")
  private long roomId;

  @Column(name = "NAME")
  private String name;

  @Column(name = "ROOM_NUMBER")
  private String roomNumber;

  @Column(name = "BED_INFO")
  private String bewInfo;

  public long getRoomId() {
    return roomId;
  }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getBewInfo() {
    return bewInfo;
  }

  public void setBewInfo(String bewInfo) {
    this.bewInfo = bewInfo;
  }
}
