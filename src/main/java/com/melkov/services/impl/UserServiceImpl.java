package com.melkov.services.impl;

import com.melkov.dao.UserDao;
import com.melkov.domain.User;
import com.melkov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by andrew on 15.09.16.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public boolean validUser(User user) {
        return userDao.validUser(user);
    }
}
