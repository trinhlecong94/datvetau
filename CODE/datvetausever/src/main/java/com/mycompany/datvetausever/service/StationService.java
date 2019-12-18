package com.mycompany.datvetausever.service;

import com.mycompany.datvetausever.entities.StationEntity;
import com.mycompany.datvetausever.repository.StationRepository;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class StationService implements Serializable {

    StationRepository stationRepository = new StationRepository();

    public List<StationEntity> findAllStation() throws ClassNotFoundException, SQLException {
        return stationRepository.findAllStation();
    }

    public StationEntity findStationByID(int id) throws ClassNotFoundException, SQLException {
        return stationRepository.findStationByID(id);
    }

    public StationEntity findStationByName(String name) throws ClassNotFoundException, SQLException {
        return stationRepository.findStationByName(name);
    }

}
