package com.example.meetingroom.repository;
import com.example.meetingroom.model.User;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UserRepository {

    private final Map<Long, User> users = new HashMap<>();
    private long idCounter = 100;

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter++);
        }
        users.put(user.getId(), user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}