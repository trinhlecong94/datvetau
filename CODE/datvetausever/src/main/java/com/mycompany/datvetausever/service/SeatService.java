package com.mycompany.datvetausever.service;

import com.mycompany.datvetausever.entities.SeatEntity;
import com.mycompany.datvetausever.repository.SeatRepository;
import java.sql.SQLException;
import java.util.List;

public class SeatService {

    SeatRepository seatRepository = new SeatRepository();

    public List<SeatEntity> findSeatsByCarriageTrainID(int id) throws ClassNotFoundException, SQLException {
        return seatRepository.findSeatsByCarriageTrainID(id);
    }

    public SeatEntity findSeatBySeatID(int id) throws ClassNotFoundException, SQLException {
        return seatRepository.findSeatBySeatID(id);
    }
}
