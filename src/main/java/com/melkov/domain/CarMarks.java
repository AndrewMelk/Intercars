package com.melkov.domain;

/**
 * Created by andrew on 30.08.16.
 */
public class CarMarks {

    private String carMark;
    private boolean top;

    public CarMarks(String carMark, boolean top) {
        this.carMark = carMark;
        this.top = top;
    }

    public CarMarks() {
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }
}
