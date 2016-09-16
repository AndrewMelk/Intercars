package com.melkov.jdbc.mappers;

import com.melkov.jdbc.extractors.CarModelsExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 05.09.16.
 */
public class CarModelsRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        CarModelsExtractor carModelsExtractor = new CarModelsExtractor();


        return carModelsExtractor.extractData(resultSet);
    }
}
