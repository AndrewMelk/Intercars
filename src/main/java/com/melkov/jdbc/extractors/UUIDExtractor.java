package com.melkov.jdbc.extractors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 26.10.16.
 */
public class UUIDExtractor implements ResultSetExtractor<Long> {
    public Long extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        return new Long(resultSet.getLong(1));
    }
}
