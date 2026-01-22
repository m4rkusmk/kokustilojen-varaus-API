package com.example.meetingroom.service;

import com.example.meetingroom.model.User;
import com.example.meetingroom.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {

        repository.findAll().forEach(existing -> {
            if (existing.getEmail().equals(user.getEmail())) {
                throw new IllegalArgumentException("User already exists");
            }
        });
        return repository.save(user);
    }

    public User get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}