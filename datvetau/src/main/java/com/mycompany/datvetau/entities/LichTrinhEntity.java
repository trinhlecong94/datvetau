package com.mycompany.datvetau.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class LichTrinhEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(nullable = false)
    private TauEntity tau;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @Column(nullable = false)
    private List<GioTauChayEntity> gioTauChays;

    @DateTimeFormat(pattern = "yyyy-mm-dd hh.mm.ss")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date gioKhoiHanh;

    public LichTrinhEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TauEntity getTau() {
        return tau;
    }

    public void setTau(TauEntity tau) {
        this.tau = tau;
    }

    public Date getGioKhoiHanh() {
        return gioKhoiHanh;
    }

    public void setGioKhoiHanh(Date gioKhoiHanh) {
        this.gioKhoiHanh = gioKhoiHanh;
    }

    public void setGioTauChays(List<GioTauChayEntity> gioTauChays) {
        this.gioTauChays = gioTauChays;
    }

    public List<GioTauChayEntity> getGioTauChays() {
        return gioTauChays;
    }
    

}
