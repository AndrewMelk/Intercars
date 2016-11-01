package com.melkov.services;

import com.melkov.domain.ImagePath;

import java.util.List;

/**
 * Created by andrew on 27.10.16.
 */
public interface ImagePathService {

    public void addImagePath(long carId ,String path);
    public void addAllImagePaths(long carId ,List<String> pathList);
    public ImagePath getImagePath(long carId);
    public List<ImagePath> getAllImagesPath(long carId);
}
