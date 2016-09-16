package com.melkov.services;

import com.melkov.domain.CarModels;

import java.util.List;

/**
 * Created by andrew on 05.09.16.
 */
public interface CarModelsService {

    public List<CarModels> getModelsByMark(String mark);

}
