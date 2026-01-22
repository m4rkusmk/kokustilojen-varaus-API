package com.example.meetingroom.service;

import com.example.meetingroom.model.MeetingRoom;
import com.example.meetingroom.repository.MeetingRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {

    private final MeetingRoomRepository repository;

    public MeetingRoomService(MeetingRoomRepository repository) {
        this.repository = repository;
    }

    public MeetingRoom create(MeetingRoom room) {

        if (room.getName().isEmpty()) {
            throw new IllegalArgumentException("Meetingroom must have a name");
        }

        repository.findAll().forEach(existing -> {
            if (existing.getName().equals(room.getName())) {
                throw new IllegalArgumentException("Meetingroom has already been created");
            }
        });
        return repository.save(room);
    }

    public MeetingRoom get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Meetingroom not found"));
    }

    public List<MeetingRoom> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}