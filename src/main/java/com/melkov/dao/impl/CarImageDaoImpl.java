package com.melkov.dao.impl;

import com.melkov.dao.CarImageDao;
import com.melkov.domain.CarImage;
import com.melkov.jdbc.mappers.CarImageRowMapper;
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

    public void addImages(CarImage carImage) throws IOException {

        String sql = "INSERT into images (car_id, image) " + "VALUES (?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.log(Level.SEVERE, carImage.toString());

        for (MultipartFile multipartFile : carImage.getFiles()){
            jdbcTemplate.update(sql, new Object[]{carImage.getCarId(), multipartFile.getBytes()});
        }





    }

    public List<MultipartFile> getImageList(int carId) {
        List<MultipartFile> list = new ArrayList<MultipartFile>();
        String sql = "SELECT * FROM images WHERE car_id=" + carId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        list = jdbcTemplate.query(sql, new CarImageRowMapper());
        return list;
    }
}
