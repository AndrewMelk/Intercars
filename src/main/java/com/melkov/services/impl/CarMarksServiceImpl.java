package com.melkov.services.impl;

import com.melkov.dao.MarkListDao;
import com.melkov.domain.CarMarks;
import com.melkov.services.CarMarksService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by andrew on 30.08.16.
 */
public class CarMarksServiceImpl implements CarMarksService {

    @Autowired
    MarkListDao markListDao;

    public List<CarMarks> getTopCarMarks() {
        return markListDao.getTopCarMarks();
    }

    public List<CarMarks> getNotTopMarks() {
        return markListDao.getNotTopMarks();
    }

    public void addMarkAndModel(CarMarks carMarks) {

    }
}
