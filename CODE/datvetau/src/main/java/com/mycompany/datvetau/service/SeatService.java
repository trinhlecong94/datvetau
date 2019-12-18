package com.mycompany.datvetau.service;

import com.mycompany.datvetau.entities.SeatEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.mycompany.datvetau.repository.SeatRepository;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public SeatEntity findSeatById(int id) {
        return seatRepository.findSeatById(id);
    }

}
