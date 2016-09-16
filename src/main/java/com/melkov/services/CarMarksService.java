package com.melkov.services;

import com.melkov.domain.CarMarks;

import java.util.List;

/**
 * Created by andrew on 30.08.16.
 */
public interface CarMarksService {

    public List<CarMarks> getTopCarMarks();
    public List<CarMarks> getNotTopMarks();
    public void addMarkAndModel(CarMarks carMarks);
}
