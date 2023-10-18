package com.example.Swift_backend.service;

import com.example.Swift_backend.model.User;

public interface UserService {
    default User createUser(User user) {
        return null;
    }
}
