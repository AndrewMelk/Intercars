package com.melkov.domain;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by andrew on 18.10.16.
 */
public class CarImage {

    private int id;
    private int carId;
    private List<MultipartFile> Files;

    public CarImage() {
    }

    public CarImage(int id, int carId, List<MultipartFile> files) {
        this.id = id;
        this.carId = carId;
        Files = files;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MultipartFile> getFiles() {
        return Files;
    }

    public void setFiles(List<MultipartFile> files) {
        Files = files;
    }

    @Override
    public String toString() {
        return "CarImage{" +
                "id=" + id +
                ", carId=" + carId +
                ", Files=" + Files +
                '}';
    }
}
