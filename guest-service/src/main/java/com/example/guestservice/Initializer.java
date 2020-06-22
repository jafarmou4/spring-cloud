package com.example.guestservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {
    private final GuestRepository guestRepository;

    public Initializer(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("James", "Jack").forEach(name -> this.guestRepository.save(new Guest(name)));
    }
}
