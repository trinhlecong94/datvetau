package com.mycompany.datvetau.entities;

import com.mycompany.datvetau.entities.enums.TrainClasses;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class ToaTauEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TrainClasses status = TrainClasses.CLASSES01;

    @OneToMany
    @Column(nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<GheNgoiEntity> gheNgoiEntitys;

    public ToaTauEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrainClasses getStatus() {
        return status;
    }

    public void setStatus(TrainClasses status) {
        this.status = status;
    }

    public List<GheNgoiEntity> getGheNgoiEntitys() {
        return gheNgoiEntitys;
    }

    public void setGheNgoiEntitys(List<GheNgoiEntity> gheNgoiEntitys) {
        this.gheNgoiEntitys = gheNgoiEntitys;
    }
    
}
