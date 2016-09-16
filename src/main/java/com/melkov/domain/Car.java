package com.melkov.domain;

/**
 * Created by andrew on 04.08.16.
 */

public class Car {


    private long id;

    // New property
    private String vehicleType;
    private String bodyType;

    private String mark;
    private String model;

    private double engineValue;
    private double consumption;
    // New property
    private int carYear;
    private int carPrice;
    private String transmissionType;
    private String typeOfDrive;
    private int mileage;
    private String city;
    private String colour;
    private String description;




    public Car() {
    }

    public Car(long id,
               String vehicleType,
               String bodyType,
               String mark,
               String model,
               double engineValue,
               double consumption,
               int carYear,
               int carPrice,
               String transmissionType,
               String typeOfDrive,
               int mileage,
               String city,
               String colour,
               String description) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.bodyType = bodyType;
        this.mark = mark;
        this.model = model;
        this.engineValue = engineValue;
        this.consumption = consumption;
        this.carYear = carYear;
        this.carPrice = carPrice;
        this.transmissionType = transmissionType;
        this.typeOfDrive = typeOfDrive;
        this.mileage = mileage;
        this.city = city;
        this.colour = colour;
        this.description = description;
    }

    public Car(long id, String mark, String model, double engineValue, double consumption) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.engineValue = engineValue;
        this.consumption = consumption;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngineValue() {
        return engineValue;
    }

    public void setEngineValue(double engineValue) {
        this.engineValue = engineValue;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(String typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" +
                "consumption=" + consumption +
                ", engineValue=" + engineValue +
                ", model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                ", id=" + id +
                '}';
    }
}
