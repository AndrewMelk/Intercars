package com.melkov.services.impl;

import com.melkov.dao.RegionDao;
import com.melkov.domain.Region;
import com.melkov.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by andrew on 28.09.16.
 */
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionDao regionDao;

    public List<Region> getListRegions() {
        return regionDao.getListRegions();
    }
}
