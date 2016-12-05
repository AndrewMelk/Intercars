package com.melkov.services;

import com.melkov.domain.CarImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by andrew on 18.10.16.
 */
public interface CarImageService {

    public void addImages(long carUUID, List<CarImage> carImages) throws IOException;
    public List<MultipartFile> getImageList(int id);

}
