package com.melkov.dao.impl;

import com.melkov.dao.UserDao;
import com.melkov.domain.User;
import com.melkov.jdbc.mappers.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andrew on 15.09.16.
 */
public class UserDaoImpl implements UserDao {
    Logger logger = Logger.getLogger(getClass().getName().toString());

    @Autowired
    DataSource dataSource;

    public void addUser(User user) {
        String sql = "INSERT INTO user " +
                "(name, email, pass) VALUES (?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, new Object[] {user.getUserName(),user.getUserEmail(),user.getUserPass()});
    }

    public boolean validUser(User user) {
        boolean isValid = false;

        List<User> userList = new ArrayList<User>();

        String sql = "SELECT * FROM user";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new UserRowMapper());
            logger.log(Level.SEVERE, "User Email: " + user.getUserEmail() + "/n" +
                                        "User Pass" + user.getUserPass());
        for(User tmpUser : userList){
            logger.log(Level.SEVERE,"Temp User Email: " + tmpUser.getUserEmail() + "/n" +
                                    "Temp User Pass: " + tmpUser.getUserPass());
            if(tmpUser.getUserEmail().equals(user.getUserEmail())&&
               tmpUser.getUserPass().equals(user.getUserPass())){
               isValid = true;

            }

        }
            return isValid;
    }
}
