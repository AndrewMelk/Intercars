package com.melkov.jdbc.mappers;

import com.melkov.jdbc.extractors.CarImageExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 20.10.16.
 */
public class CarImageRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        CarImageExtractor carImageExtractor = new CarImageExtractor();


        return carImageExtractor.extractData(resultSet);
    }
}
