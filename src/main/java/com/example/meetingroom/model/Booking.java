package com.example.meetingroom.model;
import java.time.LocalDateTime;

public class Booking {

    private Long id;
    private Long roomId;
    private Long userId;
    private LocalDateTime start;
    private LocalDateTime end;

    public Booking() {}
    public Booking(Long id, Long roomId, Long userId,
                   LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.start = start;
        this.end = end;
    }

    public Long getId() { return id; }
    public Long getRoomId() { return roomId; }
    public Long getUserId() { return userId; }
    public LocalDateTime getStart() { return start; }
    public LocalDateTime getEnd() { return end; }

    public void setId(Long id) { this.id = id; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setStart(LocalDateTime start) { this.start = start; }
    public void setEnd(LocalDateTime end) { this.end = end; }

}