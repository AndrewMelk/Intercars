package com.melkov.services.impl;

import com.melkov.dao.CarDao;
import com.melkov.domain.Car;
import com.melkov.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrew on 05.08.16.
 */
public class CarServiceImpl implements CarService {


    @Autowired
    CarDao carDao;

    @Transactional
    public Car getCarById(String id){
        return carDao.getCarById(id);
    }

    @Transactional
    public List<Car> getAllCar() {
        return carDao.getAllCar();
    }

    @Transactional
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Transactional
    public void removeCar(String id) {
        carDao.removeCar(id);
    }

    public List<Car> getCarsByMark(String mark) {
        return carDao.getCarsByMark(mark);
    }

    public List<Car> getCarsByParam(String vehicleType,
                                    String bodyType,
                                    String mark,
                                    String model,
                                    double fromEngineValue,
                                    double toEngineValue,
                                    double fromConsumption,
                                    double toConsumption,
                                    int fromCarYear,
                                    int toCarYear,
                                    int fromCarPrice,
                                    int toCarPrice,
                                    String transmissionType,
                                    String typeOfDrive,
                                    int fromMileage,
                                    int toMileage,
                                    String city,
                                    String colour,
                                    String description) {
        return carDao.getCarsByParam(vehicleType, bodyType, mark, model, fromEngineValue, toEngineValue, fromConsumption, toConsumption,
                fromCarYear, toCarYear, fromCarPrice, toCarPrice, transmissionType, typeOfDrive, fromMileage, toMileage, city, colour, description);
    }

    public List<Car> getCarsByMarkModel(String mark, String model) {
        return carDao.getCarsByMarkModel(mark, model);
    }


    @Transactional
    public void updateData(Car car){
        carDao.updateData(car);
    }


}
