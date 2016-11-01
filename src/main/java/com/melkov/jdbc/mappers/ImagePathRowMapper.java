package com.melkov.jdbc.mappers;

import com.melkov.jdbc.extractors.ImagePathExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on 27.10.16.
 */
public class ImagePathRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ImagePathExtractor extractor = new ImagePathExtractor();



        return extractor.extractData(resultSet);
    }
}
