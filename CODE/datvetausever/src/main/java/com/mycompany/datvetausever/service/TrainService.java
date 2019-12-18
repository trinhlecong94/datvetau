package com.mycompany.datvetausever.service;

import com.mycompany.datvetausever.entities.TrainEntity;
import com.mycompany.datvetausever.repository.TrainRepository;
import java.sql.SQLException;

public class TrainService {

    TrainRepository trainRepository = new TrainRepository();

    public TrainEntity getTrainByID(int id) throws ClassNotFoundException, SQLException {
        return trainRepository.getTrainByID(id);
    }
}
