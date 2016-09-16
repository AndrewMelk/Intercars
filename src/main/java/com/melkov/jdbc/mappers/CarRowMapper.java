package com.melkov.jdbc.mappers;

import com.melkov.jdbc.extractors.CarExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 05.08.16.
 */
public class CarRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        CarExtractor carExtractor = new CarExtractor();
        return carExtractor.extractData(resultSet);
    }
}
