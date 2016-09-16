package com.melkov.dao;

import com.melkov.domain.User;

/**
 * Created by andrew on 15.09.16.
 */
public interface UserDao {

    public void addUser(User user);
    public boolean validUser(User user);


}
