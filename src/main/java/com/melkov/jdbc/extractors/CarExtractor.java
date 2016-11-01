package com.melkov.jdbc.extractors;

import com.melkov.domain.Car;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 05.08.16.
 */
public class CarExtractor implements ResultSetExtractor<Car> {
    public Car extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Car car = new Car();

        car.setId(resultSet.getLong(1));
        car.setVehicleType(resultSet.getString(2));
        car.setBodyType(resultSet.getString(3));
        car.setMark(resultSet.getString(4));
        car.setModel(resultSet.getString(5));
        car.setEngineValue(resultSet.getDouble(6));
        car.setConsumption(resultSet.getDouble(7));
        car.setCarYear(resultSet.getInt(8));
        car.setCarPrice(resultSet.getInt(9));
        car.setTransmissionType(resultSet.getString(10));
        car.setTypeOfDrive(resultSet.getString(11));
        car.setMileage(resultSet.getInt(12));
        car.setCity(resultSet.getString(13));
        car.setColour(resultSet.getString(14));
        car.setDescription(resultSet.getString(15));
        car.setTitle(resultSet.getString(16));
        car.setModeification(resultSet.getString(17));
        car.setVin(resultSet.getString(18));
        car.setUsername(resultSet.getString(19));
        car.setUuid(resultSet.getLong(20));
        car.setGeneralImage(resultSet.getString(21));


        return car;
    }
}
