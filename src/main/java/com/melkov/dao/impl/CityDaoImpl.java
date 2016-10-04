package com.melkov.dao.impl;

import com.melkov.dao.CityDao;
import com.melkov.domain.City;
import com.melkov.jdbc.mappers.CityRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 28.09.16.
 */
public class CityDaoImpl implements CityDao {

    @Autowired
    DataSource dataSource;


    public List<City> getCityList(int regionId) {
        List<City> cityList = new ArrayList<City>();

        String sql = "SELECT * FROM city WHERE region_id=" + regionId;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        cityList = jdbcTemplate.query(sql, new CityRowMapper());

        return cityList;
    }

}
