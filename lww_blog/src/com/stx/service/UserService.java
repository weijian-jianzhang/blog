package com.stx.service;

import com.stx.entity.User;

public interface UserService {
    void register(User user);
    User login(User user);
    User forget(User user);
    User forgetAnswer(User user);
    void delete(User user);
}
