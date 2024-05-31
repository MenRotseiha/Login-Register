package com.project.Login.Register.service;

import com.project.Login.Register.model.User;

import java.util.Optional;

public interface UserService {
    public User saveUser(User user);
    Optional <User> userLogin(User user);
}
