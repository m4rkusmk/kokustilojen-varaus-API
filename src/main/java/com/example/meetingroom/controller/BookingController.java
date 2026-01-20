package com.example.meetingroom.controller;

import com.example.meetingroom.model.Booking;
import com.example.meetingroom.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
            return service.create(booking);
    }

    @GetMapping
    public List<Booking> list() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,
                       @RequestParam Long userId) {
        service.delete(id, userId);
    }
}