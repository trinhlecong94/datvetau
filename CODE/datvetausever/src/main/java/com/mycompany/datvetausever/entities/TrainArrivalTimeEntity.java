package com.mycompany.datvetausever.entities;

import java.io.Serializable;

public class TrainArrivalTimeEntity implements Serializable {

    private int id;

    private Long timeTrain;

    private Integer noStation;

    private double distance;

    private StationEntity station;

    public TrainArrivalTimeEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getTimeTrain() {
        return timeTrain;
    }

    public void setTimeTrain(Long timeTrain) {
        this.timeTrain = timeTrain;
    }

    public Integer getNoStation() {
        return noStation;
    }

    public void setNoStation(Integer noStation) {
        this.noStation = noStation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public StationEntity getStation() {
        return station;
    }

    public void setStation(StationEntity station) {
        this.station = station;
    }

}
