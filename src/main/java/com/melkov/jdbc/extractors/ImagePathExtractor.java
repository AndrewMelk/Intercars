package com.melkov.jdbc.extractors;

import com.melkov.domain.ImagePath;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrew on sss27.10.16.
 */
public class ImagePathExtractor implements ResultSetExtractor {
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        ImagePath imagePath = new ImagePath();



        imagePath.setPathToImage(resultSet.getString(1));

        return imagePath;
    }
}
