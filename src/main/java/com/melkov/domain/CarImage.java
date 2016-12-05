package com.melkov.domain;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by andrew on 18.10.16.
 */
public class CarImage {

    private int id;
    private int carUUID;
    private String pathToImage;

    public CarImage(int id, int carUUID, String pathToImage) {
        this.id = id;
        this.carUUID = carUUID;
        this.pathToImage = pathToImage;
    }

    public CarImage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarUUID() {
        return carUUID;
    }

    public void setCarUUID(int carUUID) {
        this.carUUID = carUUID;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    @Override
    public String toString() {
        return "CarImage{" +
                "id=" + id +
                ", carUUID=" + carUUID +
                ", pathToImage='" + pathToImage + '\'' +
                '}';
    }
}
