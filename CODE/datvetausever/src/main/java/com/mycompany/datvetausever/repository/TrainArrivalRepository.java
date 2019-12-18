package com.mycompany.datvetausever.repository;

import com.mycompany.datvetausever.conection.ConectionDB;
import com.mycompany.datvetausever.entities.TrainArrivalTimeEntity;
import com.mycompany.datvetausever.service.StationService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrainArrivalRepository {

    public List<TrainArrivalTimeEntity> findTrainsArrivalTimeByTrainID(int id) throws ClassNotFoundException, SQLException {
        ConectionDB conectionDB = new ConectionDB();
        List<TrainArrivalTimeEntity> entitys;
        try (Connection conn = conectionDB.connection()) {
            entitys = new ArrayList<>();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT id,timeTrain,noStation,distance,station_id FROM datvetau.train_train_arrival_time\n"
                        + "inner join datvetau.train_arrival_time\n"
                        + "on datvetau.train_train_arrival_time.trainArrivalTime_id=datvetau.train_arrival_time.id\n"
                        + "where TrainEntity_id=" + id;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        TrainArrivalTimeEntity trainArrivalTimeEntity = new TrainArrivalTimeEntity();
                        trainArrivalTimeEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        trainArrivalTimeEntity.setTimeTrain(Long.parseLong(rs.getObject(2).toString()));
                        trainArrivalTimeEntity.setNoStation(Integer.parseInt(rs.getObject(3).toString()));
                        trainArrivalTimeEntity.setDistance(Double.parseDouble(rs.getObject(4).toString()));
                        StationService stationService = new StationService();
                        trainArrivalTimeEntity.setStation(stationService.findStationByID(Integer.parseInt(rs.getObject(5).toString())));
                        entitys.add(trainArrivalTimeEntity);
                    }
                }
            }
        }
        return entitys;

    }

}
