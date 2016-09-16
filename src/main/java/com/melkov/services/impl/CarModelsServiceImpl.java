package com.melkov.services.impl;

import com.melkov.dao.CarModelDao;
import com.melkov.domain.CarModels;
import com.melkov.services.CarModelsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by andrew on 05.09.16.
 */
public class CarModelsServiceImpl implements CarModelsService {

    @Autowired
    CarModelDao carModelDao;

    public List<CarModels> getModelsByMark(String mark) {
        return carModelDao.getModelsByMark(mark);
    }
}
