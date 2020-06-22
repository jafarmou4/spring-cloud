package com.example.roomservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {
    private final RoomRepository roomRepository;

    public Initializer(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("L1", "L2").forEach(name -> this.roomRepository.save(new Room(name)));
    }
}
