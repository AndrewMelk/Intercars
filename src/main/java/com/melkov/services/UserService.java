package com.melkov.services;

import com.melkov.domain.User;

/**
 * Created by andrew on 15.09.16.
 */
public interface UserService {
    public void addUser(User user);
    public boolean validUser(User user);
}
