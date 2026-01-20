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
        return repository.save(room);
    }

    public List<MeetingRoom> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}