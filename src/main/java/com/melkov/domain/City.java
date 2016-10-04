package com.melkov.domain;

/**
 * Created by andrew on 28.09.16.
 */
public class City {
    private int id;
    private int regionId;
    private String name;
    private String phoneCode;

    public City() {
    }

    public City(int id, int regionId, String name, String phoneCode) {
        this.id = id;
        this.regionId = regionId;
        this.name = name;
        this.phoneCode = phoneCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", regionId=" + regionId +
                ", name='" + name + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                '}';
    }
}
