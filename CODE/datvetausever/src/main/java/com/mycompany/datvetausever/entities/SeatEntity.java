package com.mycompany.datvetausever.entities;

import java.io.Serializable;

public class SeatEntity implements Serializable {

    private int id;

    private String seatName;

    private boolean status;

    public SeatEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

}
