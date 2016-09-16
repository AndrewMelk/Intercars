package com.melkov.dao.impl;

import com.melkov.dao.MarkListDao;
import com.melkov.domain.CarMarks;
import com.melkov.jdbc.mappers.CarMarksRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 30.08.16.
 */
public class MarkListDaoImpl implements MarkListDao {

    @Autowired
    DataSource dataSourceCar;

    public List<CarMarks> getTopCarMarks() {
        List<CarMarks> carList = new ArrayList<CarMarks>();
        String sql = "select * from mark where top=1";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceCar);
        carList = jdbcTemplate.query(sql, new CarMarksRowMapper());
        return carList;
    }

    public List<CarMarks> getNotTopMarks() {
        List<CarMarks> carList = new ArrayList<CarMarks>();
        String sql = "select * from mark where top=0";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceCar);
        carList = jdbcTemplate.query(sql, new CarMarksRowMapper());
        return carList;
    }

    public void addMarkAndModel(CarMarks carMarks) {

    }
}
