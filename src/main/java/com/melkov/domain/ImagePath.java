package com.melkov.domain;

import java.util.List;

/**
 * Created by andrew on 27.10.16.
 */
public class ImagePath {

    private long id;
    private long carId;
    private String pathToImage;
//    private List<String> pathToAllimages;

    public ImagePath() {
    }

    public ImagePath(long id, long carId, String pathToImage, List<String> pathToAllimages) {
        this.id = id;
        this.carId = carId;
        this.pathToImage = pathToImage;
//        this.pathToAllimages = pathToAllimages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

//    public List<String> getPathToAllimages() {
//        return pathToAllimages;
//    }
//
//    public void setPathToAllimages(List<String> pathToAllimages) {
//        this.pathToAllimages = pathToAllimages;
//    }

    @Override
    public String toString() {
        return "ImagePath{" +
                "id=" + id +
                ", carId=" + carId +
                ", pathToImage='" + pathToImage + '\'' +
//                ", pathToAllimages=" + pathToAllimages +
                '}';
    }
}
