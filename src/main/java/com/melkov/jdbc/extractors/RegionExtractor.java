package com.melkov.jdbc.extractors;

import com.melkov.domain.Region;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 28.09.16.
 */
public class RegionExtractor implements ResultSetExtractor<Region> {
    public Region extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Region region = new Region();

        region.setId(resultSet.getInt("id"));
        region.setName(resultSet.getString("name"));

        return region;
    }
}
