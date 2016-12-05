package com.melkov.dao.impl;

import com.melkov.dao.CarImageDao;
import com.melkov.domain.CarImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andrew on 18.10.16.
 */
public class CarImageDaoImpl implements CarImageDao {
    Logger logger = Logger.getLogger(this.getClass().toString());

    @Autowired
    DataSource dataSource;

    public void addImages(long carUUID, List<CarImage> carImages) throws IOException {

    }

    public List<MultipartFile> getImageList(long carUUID) {
        return null;
    }
}
