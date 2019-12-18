package com.mycompany.datvetausever.entities;

import java.io.Serializable;
import java.util.Date;

public class ScheduleEntity implements Serializable {

    private int id;

    private TrainEntity train;

    private Date departureTime;

    public ScheduleEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrainEntity getTrain() {
        return train;
    }

    public void setTrain(TrainEntity train) {
        this.train = train;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

}
