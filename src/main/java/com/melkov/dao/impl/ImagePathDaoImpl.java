package com.melkov.dao.impl;

import com.melkov.dao.ImagePathDao;
import com.melkov.domain.ImagePath;
import com.melkov.jdbc.mappers.ImagePathRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 27.10.16.
 */
public class ImagePathDaoImpl implements ImagePathDao{

    @Autowired
    DataSource dataSource;

    public void addImagePath(long carId ,String path) {
        String sql = "INSERT into image_paths (car_id,image_path) VALUES (?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, new Object[]{carId,path});

    }

    public void addAllImagePaths(long carId , List<String> pathList) {

        String sql = "INSERT into image_paths (carId,image_path) VALUES (?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        for (String path : pathList){

            jdbcTemplate.update(sql, new Object[]{carId,path});
        }

    }

    public ImagePath getImagePath(long carId) {
        String sql = "SELECT * FROM image_paths WHERE carId=" + carId + "LIMIT 1";
        List<ImagePath> imagePathArrayList = new ArrayList<ImagePath>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        imagePathArrayList = jdbcTemplate.query(sql, new ImagePathRowMapper());

        return imagePathArrayList.get(0);
    }

    public List<ImagePath> getAllImagesPath(long carId) {
        String sql = "SELECT * FROM image_paths WHERE carId=" + carId;
        List<ImagePath> imagePathArrayList = new ArrayList<ImagePath>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        imagePathArrayList = jdbcTemplate.query(sql, new ImagePathRowMapper());

        return imagePathArrayList;
    }
}
