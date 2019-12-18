//ok
package com.mycompany.datvetau.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "train_arrival_time")
public class TrainArrivalTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Long timeTrain;

    @Column(nullable = false)
    private Integer noStation;

    @Column(nullable = false)
    private double distance;

    @ManyToOne
    @JoinColumn(nullable = false)
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
