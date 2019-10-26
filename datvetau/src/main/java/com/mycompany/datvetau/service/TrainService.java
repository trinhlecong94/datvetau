package com.mycompany.datvetau.service;

import com.mycompany.datvetau.entities.TrainEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.mycompany.datvetau.repository.TrainRepository;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<TrainEntity> findAllTrain() {
        return (List<TrainEntity>) trainRepository.findAll();
    }

    public TrainEntity findTrainByName(String nameTrain) {
        return trainRepository.findTrainByName(nameTrain);
    }

    public String findTrainNameBySeatId(int seatId) {
        return trainRepository.findTrainNameBySeatId(seatId);
    }

}
