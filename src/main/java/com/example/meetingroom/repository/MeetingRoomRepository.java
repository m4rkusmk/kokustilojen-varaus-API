package com.example.meetingroom.repository;
import com.example.meetingroom.model.MeetingRoom;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MeetingRoomRepository {
    
    private final Map<Long, MeetingRoom> rooms = new HashMap<>();
    private long idCounter = 1;
    
    public MeetingRoom save(MeetingRoom room) {
        
        if (room.getId() == null) {
            room.setId(idCounter++);
        }
        rooms.put(room.getId(), room);
        return room;
    }

    public List<MeetingRoom> findAll() {
        return new ArrayList<>(rooms.values());
    }
    public Optional<MeetingRoom> findById(Long id) {
        return Optional.ofNullable(rooms.get(id));
    }
    public void delete(Long id) {
        rooms.remove(id);
    }
}