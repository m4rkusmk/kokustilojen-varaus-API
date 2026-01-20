package com.example.meetingroom.controller;

import com.example.meetingroom.model.MeetingRoom;
import com.example.meetingroom.service.MeetingRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
public class RoomController {

    private final MeetingRoomService service;

    public RoomController(MeetingRoomService service) {
        this.service = service;
    }

    @PostMapping
    public MeetingRoom create(@RequestBody MeetingRoom room) {
        return service.create(room);
    }

    @GetMapping
    public List<MeetingRoom> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MeetingRoom get(@PathVariable Long id) {
        return service.get(id);
    }
}