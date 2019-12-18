package com.mycompany.datvetau.entities;

import com.mycompany.datvetau.entities.enums.TrainClasses;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "carriage_train")
public class CarriageTrainEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TrainClasses classes = TrainClasses.CLASSES01;

    private String carriageName;

    @OneToMany
    @Column(nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
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
