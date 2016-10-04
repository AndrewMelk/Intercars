package com.melkov.domain;

/**
 * Created by andrew on 08.09.16.
 */
public class SearchBean {

    private String vehicleType;
    private  String bodyType;
    private  String mark;
    private   String model;
    private   double fromEngineValue;
    private   double toEngineValue;
    private   double fromConsumption;
    private   double toConsumption;
    private   int fromCarYear;
    private   int toCarYear;
    private   int fromCarPrice;
    private   int toCarPrice;
    private  String transmissionType;
    private  String typeOfDrive;
    private  int fromMileage;
    private   int toMileage;
    private  String city;
    private  String colour;
    private  String description;


    public SearchBean(String vehicleTyp, String bodyTyp, String mar, String model, double fromEngineValue, double toEngineValue, double fromConsumption, double toConsumption, int fromCarYear, int toCarYear, int fromCarPrice, int toCarPrice, String transmissionType, String typeOfDrive, int fromMileage, int toMileage, String city, String colour, String description) {
        this.vehicleType = vehicleTyp;
        this.bodyType = bodyTyp;
        this.mark = mar;
        this.model = model;
        this.fromEngineValue = fromEngineValue;
        this.toEngineValue = toEngineValue;
        this.fromConsumption = fromConsumption;
        this.toConsumption = toConsumption;
        this.fromCarYear = fromCarYear;
        this.toCarYear = toCarYear;
        this.fromCarPrice = fromCarPrice;
        this.toCarPrice = toCarPrice;
        this.transmissionType = transmissionType;
        this.typeOfDrive = typeOfDrive;
        this.fromMileage = fromMileage;
        this.toMileage = toMileage;
        this.city = city;
        this.colour = colour;
        this.description = description;
    }



    public SearchBean() {
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

    public String getMark() {
        return mark;
    }

    public void setMark(String mar) {
        this.mark = mar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFromEngineValue() {
        return fromEngineValue;
    }

    public void setFromEngineValue(double fromEngineValue) {
        this.fromEngineValue = fromEngineValue;
    }

    public double getToEngineValue() {
        return toEngineValue;
    }

    public void setToEngineValue(double toEngineValue) {
        this.toEngineValue = toEngineValue;
    }

    public double getFromConsumption() {
        return fromConsumption;
    }

    public void setFromConsumption(double fromConsumption) {
        this.fromConsumption = fromConsumption;
    }

    public double getToConsumption() {
        return toConsumption;
    }

    public void setToConsumption(double toConsumption) {
        this.toConsumption = toConsumption;
    }

    public int getFromCarYear() {
        return fromCarYear;
    }

    public void setFromCarYear(int fromCarYear) {
        this.fromCarYear = fromCarYear;
    }

    public int getToCarYear() {
        return toCarYear;
    }

    public void setToCarYear(int toCarYear) {
        this.toCarYear = toCarYear;
    }

    public int getFromCarPrice() {
        return fromCarPrice;
    }

    public void setFromCarPrice(int fromCarPrice) {
        this.fromCarPrice = fromCarPrice;
    }

    public int getToCarPrice() {
        return toCarPrice;
    }

    public void setToCarPrice(int toCarPrice) {
        this.toCarPrice = toCarPrice;
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

    public int getFromMileage() {
        return fromMileage;
    }

    public void setFromMileage(int fromMileage) {
        this.fromMileage = fromMileage;
    }

    public int getToMileage() {
        return toMileage;
    }

    public void setToMileage(int toMileage) {
        this.toMileage = toMileage;
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
}
