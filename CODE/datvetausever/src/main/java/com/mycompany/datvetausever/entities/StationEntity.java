package com.mycompany.datvetausever.entities;

import java.io.Serializable;

public class StationEntity implements Serializable {

    private int id;

    private String stationName;

    private String address;

    public StationEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
