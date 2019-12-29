package com.stx.service.impl;

import com.stx.dao.UserDao;
import com.stx.dao.impl.UserDaoImpl;
import com.stx.entity.User;
import com.stx.service.UserService;

import java.sql.Timestamp;
import java.util.List;


public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();

    @Override
    public void register(User user) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        user.setLastLoginTime(time);
        user.setRegistrationDate(time);
        ud.Register(user);
    }


    @Override
    public User login(User user) {
        List<User> users = ud.selectAll();
        for (User u : users) {
            if (u.equals(user)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User forget(User user) {
        List<User> users = ud.selectAll();
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User forgetAnswer(User user) {
        List<User> users = ud.selectAll();
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                if (u.getAnswer().equals(user.getAnswer())){
                    return u;
                }
            }
        }
        return null;
    }

    @Override
    public void delete(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.delete(user);
    }

}
