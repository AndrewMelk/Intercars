package com.melkov.services.impl;

import com.melkov.dao.CityDao;
import com.melkov.domain.City;
import com.melkov.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by andrew on 28.09.16.
 */
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

    public List<City> getCityList(int regionId) {
        return cityDao.getCityList(regionId);
    }
}
