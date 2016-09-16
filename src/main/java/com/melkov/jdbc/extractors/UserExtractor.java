package com.melkov.jdbc.extractors;

import com.melkov.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 15.09.16.
 */
public class UserExtractor implements ResultSetExtractor<User> {
    public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        User user = new User();

        user.setId(resultSet.getInt(1));
        user.setUserName(resultSet.getString(2));
        user.setUserEmail(resultSet.getString(3));
        user.setUserPass(resultSet.getString(4));

        return user;
    }
}
