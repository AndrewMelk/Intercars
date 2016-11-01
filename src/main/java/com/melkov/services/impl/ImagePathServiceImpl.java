package com.melkov.services.impl;

import com.melkov.dao.ImagePathDao;
import com.melkov.domain.ImagePath;
import com.melkov.services.ImagePathService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by andrew on 27.10.16.
 */
public class ImagePathServiceImpl implements ImagePathService {

    @Autowired
    ImagePathDao imagePathDao;

    public void addImagePath(long carId, String path) {
        imagePathDao.addImagePath(carId,path);
    }

    public void addAllImagePaths(long carId, List<String> pathList) {
        addAllImagePaths(carId,pathList);
    }

    public ImagePath getImagePath(long carId) {
        return imagePathDao.getImagePath(carId);
    }

    public List<ImagePath> getAllImagesPath(long carId) {
        return imagePathDao.getAllImagesPath(carId);
    }
}
