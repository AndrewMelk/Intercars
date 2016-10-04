package com.melkov.jdbc.mappers;

import com.melkov.domain.City;
import com.melkov.jdbc.extractors.CityExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 28.09.16.
 */
public class CityRowMapper implements RowMapper<City> {
    public City mapRow(ResultSet resultSet, int i) throws SQLException {
        CityExtractor cityExtractor = new CityExtractor();



        return cityExtractor.extractData(resultSet);
    }
}
