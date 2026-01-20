package com.example.meetingroom.repository;
import com.example.meetingroom.model.Booking;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class BookingRepository {

    private final Map<Long, Booking> bookings = new HashMap<>();
    private long idCounter = 1000;

    public Booking save(Booking booking) {

        if (booking.getId() == null) {
            booking.setId(idCounter++);
        }
        bookings.put(booking.getId(), booking);
        return booking;
    }

    public List<Booking> findAll() {
        return new ArrayList<>(bookings.values());
    }
    public Optional<Booking> findById(Long id) {
        return Optional.ofNullable(bookings.get(id));
    }
    public void delete(Long id) {
        bookings.remove(id);
    }
}