package com.dilipkumarayadav.practicalN012.service;

import com.dilipkumarayadav.practicalN012.entity.User;
import com.dilipkumarayadav.practicalN012.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String addUser(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "User name cannot be empty!";
        }
        repository.save(new User(name.trim()));
        return "User added successfully!";
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
