package com.example.roomserviceopenfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "ROOM-SERVICE")
public interface RoomRepositoryWebService {
    @GetMapping("/rooms")
    List<Room> getAllRooms();
}
