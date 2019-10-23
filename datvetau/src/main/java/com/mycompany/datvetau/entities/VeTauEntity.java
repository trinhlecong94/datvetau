package com.mycompany.datvetau.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class VeTauEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String maSo;

    @DateTimeFormat(pattern = "yyyy-mm-dd hh.mm.ss ")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date ngayKhoiHanh;

    private String tenKhachHang;

    private String maSoNhanThan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    private NhaGaEntity gaKhoiHanh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    private NhaGaEntity gaDen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private GheNgoiEntity gheNgoi;

    public VeTauEntity() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public Date getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(Date ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public NhaGaEntity getGaKhoiHanh() {
        return gaKhoiHanh;
    }

    public void setGaKhoiHanh(NhaGaEntity gaKhoiHanh) {
        this.gaKhoiHanh = gaKhoiHanh;
    }

    public NhaGaEntity getGaDen() {
        return gaDen;
    }

    public void setGaDen(NhaGaEntity gaDen) {
        this.gaDen = gaDen;
    }

    public GheNgoiEntity getGheNgoi() {
        return gheNgoi;
    }

    public void setGheNgoi(GheNgoiEntity gheNgoi) {
        this.gheNgoi = gheNgoi;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaSoNhanThan() {
        return maSoNhanThan;
    }

    public void setMaSoNhanThan(String maSoNhanThan) {
        this.maSoNhanThan = maSoNhanThan;
    }

}
