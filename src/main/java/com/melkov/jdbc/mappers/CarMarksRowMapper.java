package com.melkov.jdbc.mappers;

import com.melkov.jdbc.extractors.CarMarksExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 30.08.16.
 */
public class CarMarksRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        CarMarksExtractor carMarksExtractor = new CarMarksExtractor();
        return carMarksExtractor.extractData(resultSet);
    }
}