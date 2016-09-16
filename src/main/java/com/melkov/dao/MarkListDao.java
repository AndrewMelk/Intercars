package com.melkov.dao;

import com.melkov.domain.CarMarks;

import java.util.List;

/**
 * Created by andrew on 30.08.16.
 */
public interface MarkListDao {
    public List<CarMarks> getTopCarMarks();
    public List<CarMarks> getNotTopMarks();
    public void addMarkAndModel(CarMarks carMarks);

}
