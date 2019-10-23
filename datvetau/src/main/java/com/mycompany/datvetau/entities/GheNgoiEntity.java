//ok
package com.mycompany.datvetau.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class GheNgoiEntity implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private TauEntity tau;

    @OneToMany
    @Column(nullable = false)
    private List<TrangThaiGheEntity> trangthai;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private LichTrinhEntity lichTrinh;

    public GheNgoiEntity() {
    }

    public GheNgoiEntity(int id, TauEntity tau, List<TrangThaiGheEntity> trangthai, LichTrinhEntity lichTrinh) {
        this.id = id;
        this.tau = tau;
        this.trangthai = trangthai;
        this.lichTrinh = lichTrinh;
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

    public List<TrangThaiGheEntity> getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(List<TrangThaiGheEntity> trangthai) {
        this.trangthai = trangthai;
    }

    public LichTrinhEntity getLichTrinh() {
        return lichTrinh;
    }

    public void setLichTrinh(LichTrinhEntity lichTrinh) {
        this.lichTrinh = lichTrinh;
    }



}
