package com.melkov.dao.impl;

import com.melkov.dao.CarModelDao;
import com.melkov.domain.CarModels;

import com.melkov.jdbc.mappers.CarModelsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 05.09.16.
 */
public class CarModelDaoImpl implements CarModelDao {

    @Autowired
    DataSource dataSourceCar;

    public List<CarModels> getModelsByMark(String mark) {
        List<CarModels> carModelsList = new ArrayList<CarModels>();

        String sql = "select * from models where mark_name="+ "'" + mark + "'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceCar);
        carModelsList = jdbcTemplate.query(sql, new CarModelsRowMapper());

        return carModelsList;
    }
}
