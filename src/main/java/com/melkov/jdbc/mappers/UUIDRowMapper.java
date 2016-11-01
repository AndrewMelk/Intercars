package com.melkov.jdbc.mappers;

import com.melkov.jdbc.extractors.UUIDExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 26.10.16.
 */
public class UUIDRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Long uuid;
        UUIDExtractor extractor = new UUIDExtractor();

        uuid = extractor.extractData(resultSet);
        return uuid;
    }
}
