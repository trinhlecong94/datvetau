package com.mycompany.datvetausever.repository;

import com.mycompany.datvetausever.conection.ConectionDB;
import com.mycompany.datvetausever.entities.CarriageTrainEntity;
import com.mycompany.datvetausever.entities.enumes.TrainClasses;
import com.mycompany.datvetausever.service.SeatService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarriageTrainRepository {

    public List<CarriageTrainEntity> findCarriageTrainsByTrainID(int id) throws ClassNotFoundException, SQLException {
        ConectionDB conectionDB = new ConectionDB();
        List<CarriageTrainEntity> entitys;
        try (Connection conn = conectionDB.connection()) {
            entitys = new ArrayList<>();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT id,classes,carriageName,carriageTrains_id FROM datvetau.train_carriage_train \n"
                        + "INNER JOIN datvetau.carriage_train \n"
                        + "ON train_carriage_train .carriageTrains_id = carriage_train.id\n"
                        + "where TrainEntity_id=" + id;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        CarriageTrainEntity carriageTrainEntity = new CarriageTrainEntity();
                        carriageTrainEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        carriageTrainEntity.setClasses(TrainClasses.valueOf(rs.getObject(2).toString()));
                        carriageTrainEntity.setCarriageName(rs.getObject(3).toString());
                        SeatService seatService = new SeatService();
                        carriageTrainEntity.setSeats(seatService.findSeatsByCarriageTrainID(Integer.parseInt(rs.getObject(4).toString())));
                        entitys.add(carriageTrainEntity);
                    }
                }
            }
        }
        return entitys;
    }
}
