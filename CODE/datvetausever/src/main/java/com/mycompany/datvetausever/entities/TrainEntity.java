package com.mycompany.datvetausever.entities;

import java.io.Serializable;
import java.util.List;

public class TrainEntity implements Serializable {

    private int id;

    private String trainName;

    private List<CarriageTrainEntity> carriageTrains;

    private List<TrainArrivalTimeEntity> trainArrivalTime;

    public TrainEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<CarriageTrainEntity> getCarriageTrains() {
        return carriageTrains;
    }

    public void setCarriageTrains(List<CarriageTrainEntity> carriageTrain) {
        this.carriageTrains = carriageTrain;
    }

    public List<TrainArrivalTimeEntity> getTrainArrivalTime() {
        return trainArrivalTime;
    }

    public void setTrainArrivalTime(List<TrainArrivalTimeEntity> trainArrivalTime) {
        this.trainArrivalTime = trainArrivalTime;
    }

}
