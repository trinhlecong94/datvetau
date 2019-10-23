//ok
package com.mycompany.datvetau.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GheNgoiEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tenGheNgoi;

    public GheNgoiEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenGheNgoi() {
        return tenGheNgoi;
    }

    public void setTenGheNgoi(String tenGheNgoi) {
        this.tenGheNgoi = tenGheNgoi;
    }
}
