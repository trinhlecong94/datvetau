package com.mycompany.datvetausever.entities;

import com.mycompany.datvetausever.entities.enumes.TrainClasses;
import java.io.Serializable;
import java.util.List;

public class CarriageTrainEntity implements Serializable {

    private int id;

    private TrainClasses classes = TrainClasses.CLASSES01;

    private String carriageName;

    private List<SeatEntity> seats;

    public CarriageTrainEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrainClasses getClasses() {
        return classes;
    }

    public void setClasses(TrainClasses classes) {
        this.classes = classes;
    }

    public List<SeatEntity> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatEntity> seats) {
        this.seats = seats;
    }

    public void setCarriageName(String carriageName) {
        this.carriageName = carriageName;
    }

    public String getCarriageName() {
        return carriageName;
    }

}
