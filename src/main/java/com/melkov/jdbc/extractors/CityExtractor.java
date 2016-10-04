package com.melkov.jdbc.extractors;

import com.melkov.domain.City;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 28.09.16.
 */
public class CityExtractor implements ResultSetExtractor<City> {
    public City extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        City city = new City();

        city.setId(resultSet.getInt(1));
        city.setRegionId(resultSet.getInt(2));
        city.setName(resultSet.getString(3));
        city.setPhoneCode(resultSet.getString(4));

        return city;
    }
}
