package com.stx.dao;
import com.stx.entity.User;

import java.util.List;

public interface UserDao {

    List<User> selectAll();
    User selectByUserId(User user);
    User selectByUserName(User user);
    void Register(User user);
    void forget(User user);
    void delete(User user);
}
