package com.melkov.domain;

/**
 * Created by andrew on 05.09.16.
 */
public class CarModels {

    private int id;
    private String markName;
    private String modelName;

    public CarModels() {
    }

    public CarModels(int id, String markName, String modelName) {
        this.id = id;
        this.markName = markName;
        this.modelName = modelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
