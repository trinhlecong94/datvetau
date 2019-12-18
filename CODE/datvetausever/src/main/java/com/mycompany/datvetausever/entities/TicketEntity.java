package com.mycompany.datvetausever.entities;

import java.io.Serializable;
import java.util.Date;

public class TicketEntity implements Serializable {

    private int id;

    private String code;

    private Date departureTime;

    private String fullName;

    private String identityNumber;

    private StationEntity fromSation;

    private StationEntity toStation;

    private SeatEntity seat;

    public TicketEntity() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public StationEntity getFromSation() {
        return fromSation;
    }

    public void setFromSation(StationEntity fromSation) {
        this.fromSation = fromSation;
    }

    public StationEntity getToStation() {
        return toStation;
    }

    public void setToStation(StationEntity toStation) {
        this.toStation = toStation;
    }

    public SeatEntity getSeat() {
        return seat;
    }

    public void setSeat(SeatEntity seat) {
        this.seat = seat;
    }

}
