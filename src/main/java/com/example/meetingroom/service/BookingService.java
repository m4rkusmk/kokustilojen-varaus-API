package com.example.meetingroom.service;
import com.example.meetingroom.model.Booking;
import com.example.meetingroom.repository.BookingRepository;
import com.example.meetingroom.repository.MeetingRoomRepository;
import com.example.meetingroom.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepo;
    private final MeetingRoomRepository roomRepo;
    private final UserRepository userRepo;

    public BookingService(BookingRepository bookingRepo,
                          MeetingRoomRepository roomRepo,
                          UserRepository userRepo) {
        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
        this.userRepo = userRepo;
    }

    public Booking create(Booking booking) {

        roomRepo.findById(booking.getRoomId())
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));

        userRepo.findById(booking.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (booking.getStart().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Cannot book in the past");
        }

        if (booking.getEnd().isBefore(booking.getStart())) {
            throw new IllegalArgumentException("End time must be after start time");
        }

        bookingRepo.findAll().forEach(existing -> {
            if (existing.getRoomId().equals(booking.getRoomId())) {
                boolean overlaps =
                        booking.getStart().isBefore(existing.getEnd()) &&
                                booking.getEnd().isAfter(existing.getStart());

                if (overlaps) {
                    throw new IllegalArgumentException("Room already booked by another user");
                }
            }
        });

        return bookingRepo.save(booking);
    }

    public List<Booking> findAll() {
        return bookingRepo.findAll();
    }

    public void delete(Long bookingId, Long userId) {
        Booking booking = bookingRepo.findById(bookingId)
                        .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        if (!booking.getUserId().equals(userId)) {
            throw new IllegalArgumentException("You can only delete your own bookings");
        }
        bookingRepo.delete(bookingId);
    }

}