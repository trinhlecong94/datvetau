package com.mycompany.datvetausever.service;

import com.mycompany.datvetausever.entities.ScheduleEntity;
import com.mycompany.datvetausever.repository.ScheduleRepository;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ScheduleService {

    ScheduleRepository scheduleRepository = new ScheduleRepository();

    public List<ScheduleEntity> findSchedulesByDate(Date date) throws ClassNotFoundException, SQLException, ParseException {
        return scheduleRepository.findSchedulesByDate(date);
    }

    public List<ScheduleEntity> findSchedulesByDateAndTrain(java.sql.Date valueOf, int trainID) throws ClassNotFoundException, SQLException, ParseException {
        return scheduleRepository.findSchedulesByDate(valueOf, trainID);
    }
}
