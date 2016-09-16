package com.melkov.jdbc.extractors;

import com.melkov.domain.CarMarks;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 30.08.16.
 */
public class CarMarksExtractor implements ResultSetExtractor<CarMarks> {
    public CarMarks extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        CarMarks car = new CarMarks();

        car.setCarMark(resultSet.getString(1));
        car.setTop(resultSet.getBoolean(2));



        return car;
    }
}