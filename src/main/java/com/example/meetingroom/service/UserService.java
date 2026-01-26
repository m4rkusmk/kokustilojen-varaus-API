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

        Integer email_length = user.getEmail().length();
        
        if (!user.getEmail().substring(email_length -12, email_length -3).equals("mycompany")) {
            throw new IllegalArgumentException("User must have a company email");
        }
        repository.findAll().forEach(existing -> {
            if (existing.getEmail().equals(user.getEmail())) {
                throw new IllegalArgumentException("User with email: " + user.getEmail() + " already exists");
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

    public void delete(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        repository.delete(id);
    }
}