package com.mycompany.datvetau.service;

import com.mycompany.datvetau.entities.StationEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.mycompany.datvetau.repository.StationRepository;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public List<StationEntity> findAllStation() {
        return (List<StationEntity>) stationRepository.findAll();
    }
    
    public StationEntity findStationByName(String stationName) {
        return stationRepository.findStationByName(stationName);
    }

}
