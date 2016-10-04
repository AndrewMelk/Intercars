package com.melkov.jdbc.mappers;

import com.melkov.domain.Region;
import com.melkov.jdbc.extractors.RegionExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 28.09.16.
 */
public class RegionRowMapper implements RowMapper<Region> {
    public Region mapRow(ResultSet resultSet, int i) throws SQLException {
        RegionExtractor regionExtractor = new RegionExtractor();

        return regionExtractor.extractData(resultSet);

    }
}
