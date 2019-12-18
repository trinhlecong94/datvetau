package com.mycompany.datvetausever.repository;

import com.mycompany.datvetausever.conection.ConectionDB;
import com.mycompany.datvetausever.entities.TrainEntity;
import com.mycompany.datvetausever.service.CarriageTrainService;
import com.mycompany.datvetausever.service.TrainArrivalTimeService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TrainRepository {

    public TrainEntity getTrainByID(int id) throws ClassNotFoundException, SQLException {
        ConectionDB conectionDB = new ConectionDB();
        TrainEntity trainEntity;
        try (Connection conn = conectionDB.connection()) {
            trainEntity = new TrainEntity();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM datvetau.train where id =" + id;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        trainEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        trainEntity.setTrainName(rs.getObject(2).toString());
                        CarriageTrainService carriageTrainService = new CarriageTrainService();
                        trainEntity.setCarriageTrains(carriageTrainService.findCarriageTrainsByTrainID(Integer.parseInt(rs.getObject(1).toString())));
                        
                        TrainArrivalTimeService arrivalTimeService = new TrainArrivalTimeService();
                        trainEntity.setTrainArrivalTime(arrivalTimeService.findTrainsArrivalTimeByTrainID(Integer.parseInt(rs.getObject(1).toString())));
                    }
                }
            }
        }
        return trainEntity;

    }

}
