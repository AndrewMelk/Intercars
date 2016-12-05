package com.melkov.dao;

import com.melkov.domain.CarImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by andrew on 18.10.16.
 */
public interface CarImageDao {

    public void addImages(long carUUID, List<CarImage> carImages) throws IOException;
    public List<MultipartFile> getImageList(long carUUID);

}
