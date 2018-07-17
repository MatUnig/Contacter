package com.contacter.service;

import com.contacter.entity.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}