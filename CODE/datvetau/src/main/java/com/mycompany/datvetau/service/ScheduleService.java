package com.mycompany.datvetau.service;

import com.mycompany.datvetau.entities.ScheduleEntity;
import com.mycompany.datvetau.entities.TrainEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.datvetau.repository.ScheduleRepository;
import java.util.Date;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<ScheduleEntity> findAll() {
        return (List<ScheduleEntity>) scheduleRepository.findAll();
    }

    public ScheduleEntity findSchedulebyTrain(TrainEntity train) {
        return scheduleRepository.findSchedulebyTrain(train);
    }

    public List<ScheduleEntity> findScheduleByDate(Date departureTime) {
        return (List<ScheduleEntity>) scheduleRepository.findScheduleByDate(departureTime);
    }

    public List<ScheduleEntity> findScheduleByDateAndTrain(Date departureTime, TrainEntity train) {
        return (List<ScheduleEntity>) scheduleRepository.findScheduleByDateAndTrain(departureTime, train);
    }
}
