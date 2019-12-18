package com.mycompany.datvetau.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "train")
public class TrainEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String trainName;

    @OneToMany
    @Column(nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CarriageTrainEntity> carriageTrains;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @Column(nullable = false)
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
