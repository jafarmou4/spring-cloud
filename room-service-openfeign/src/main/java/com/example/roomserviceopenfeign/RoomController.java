package com.example.roomserviceopenfeign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private final RoomRepositoryWebService roomRepositoryWebService;

    public RoomController(RoomRepositoryWebService roomRepositoryWebService) {
        this.roomRepositoryWebService = roomRepositoryWebService;
    }

    @GetMapping("/feign-rooms")
    public List<Room> getAllRooms() {
        return this.roomRepositoryWebService.getAllRooms();
    }
}
