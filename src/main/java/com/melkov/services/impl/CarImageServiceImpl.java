package com.melkov.services.impl;

import com.melkov.dao.CarImageDao;
import com.melkov.domain.CarImage;
import com.melkov.services.CarImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by andrew on 18.10.16.
 */
public class CarImageServiceImpl implements CarImageService {

    @Autowired
    CarImageDao carImageDao;

    public void addImages(long carUUID, List<CarImage> carImages) throws IOException {
        carImageDao.addImages(carUUID,carImages);
    }

    public List<MultipartFile> getImageList(int id) {

        return carImageDao.getImageList(id);
    }
}
