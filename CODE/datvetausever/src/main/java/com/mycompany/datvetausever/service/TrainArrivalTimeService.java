package com.mycompany.datvetausever.service;

import com.mycompany.datvetausever.entities.TrainArrivalTimeEntity;
import com.mycompany.datvetausever.repository.TrainArrivalRepository;
import java.sql.SQLException;
import java.util.List;

public class TrainArrivalTimeService {
   TrainArrivalRepository trainArrivalRepository = new  TrainArrivalRepository();
   
       public List<TrainArrivalTimeEntity> findTrainsArrivalTimeByTrainID(int id) throws ClassNotFoundException, SQLException {
        return trainArrivalRepository.findTrainsArrivalTimeByTrainID(id);
    }
}
