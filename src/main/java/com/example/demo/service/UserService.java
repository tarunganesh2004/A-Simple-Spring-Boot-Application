package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private Map<Long, User> users = new HashMap<>();
    private long currentId = 1;

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(Long id) {
        return users.get(id);
    }

    public User createUser(User user) {
        user.setId(currentId++);
        users.put(user.getId(), user);
        return user;
    }

    public User updateUser(Long id, User updatedUser) {
        User user = users.get(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            users.put(id, user);
            return user;
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        return users.remove(id) != null;
    }
}
