package com.melkov.jdbc.extractors;

import com.melkov.domain.CarModels;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 05.09.16.
 */
public class CarModelsExtractor implements ResultSetExtractor<CarModels> {
    public CarModels extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        CarModels carModels = new CarModels();

        carModels.setMarkName(resultSet.getString(1));
        carModels.setModelName(resultSet.getString(2));

        return carModels;
    }
}
