//ok
package com.mycompany.datvetau.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class GioTauChayEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long thoiGian;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private NhaGaEntity nhaGa;

    public GioTauChayEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Long thoiGian) {
        this.thoiGian = thoiGian;
    }

    public NhaGaEntity getNhaGa() {
        return nhaGa;
    }

    public void setNhaGa(NhaGaEntity nhaGa) {
        this.nhaGa = nhaGa;
    }

}
