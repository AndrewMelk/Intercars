package com.melkov.dao.impl;

import com.melkov.dao.RegionDao;
import com.melkov.domain.Region;
import com.melkov.jdbc.mappers.RegionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 28.09.16.
 */
public class RegionDaoImpl implements RegionDao {
    @Autowired
    DataSource dataSource;

    public List<Region> getListRegions() {
        List<Region> regions = new ArrayList<Region>();
        String sql = "SELECT * FROM region";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        regions = jdbcTemplate.query(sql, new RegionRowMapper());

        return regions;
    }
}
