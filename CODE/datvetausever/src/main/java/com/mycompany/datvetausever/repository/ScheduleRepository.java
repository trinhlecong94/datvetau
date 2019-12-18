package com.mycompany.datvetausever.repository;

import com.mycompany.datvetausever.conection.ConectionDB;
import com.mycompany.datvetausever.entities.ScheduleEntity;
import com.mycompany.datvetausever.service.TrainService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ScheduleRepository {

    public List<ScheduleEntity> findSchedulesByDate(Date date) throws ClassNotFoundException, SQLException, ParseException {
        ConectionDB conectionDB = new ConectionDB();
        List<ScheduleEntity> scheduleEntitys;
        try (Connection conn = conectionDB.connection()) {
            scheduleEntitys = new ArrayList<>();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM datvetau.schedule where departureTime='" + date.toString() + "'";
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        ScheduleEntity scheduleEntity = new ScheduleEntity();
                        scheduleEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        scheduleEntity.setDepartureTime(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getObject(2).toString()));
                        TrainService trainService = new TrainService();
                        scheduleEntity.setTrain(trainService.getTrainByID(Integer.parseInt(rs.getObject(3).toString())));
                        scheduleEntitys.add(scheduleEntity);
                    }
                }
            }
        }
        return scheduleEntitys;
    }

    public List<ScheduleEntity> findSchedulesByDate(java.sql.Date valueOf, int trainID) throws ClassNotFoundException, SQLException, ParseException {
        ConectionDB conectionDB = new ConectionDB();
        List<ScheduleEntity> scheduleEntitys;
        try (Connection conn = conectionDB.connection()) {
            scheduleEntitys = new ArrayList<>();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM datvetau.schedule where departureTime='" + valueOf.toString() + "' and train_id=" + trainID;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        ScheduleEntity scheduleEntity = new ScheduleEntity();
                        scheduleEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        scheduleEntity.setDepartureTime(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getObject(2).toString()));
                        TrainService trainService = new TrainService();
                        scheduleEntity.setTrain(trainService.getTrainByID(Integer.parseInt(rs.getObject(3).toString())));
                        scheduleEntitys.add(scheduleEntity);
                    }
                }
            }
        }
        return scheduleEntitys;

    }
}
