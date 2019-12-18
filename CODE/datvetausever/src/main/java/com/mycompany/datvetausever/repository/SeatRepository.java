package com.mycompany.datvetausever.repository;

import com.mycompany.datvetausever.conection.ConectionDB;
import com.mycompany.datvetausever.entities.SeatEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeatRepository {

    public List<SeatEntity> findSeatsByCarriageTrainID(int id) throws ClassNotFoundException, SQLException {
        ConectionDB conectionDB = new ConectionDB();
        List<SeatEntity> entitys;
        try (Connection conn = conectionDB.connection()) {
            entitys = new ArrayList<>();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT id,seatName FROM  datvetau.carriage_train_seat \n"
                        + "INNER JOIN datvetau.seat \n"
                        + "ON datvetau.carriage_train_seat.seats_id = datvetau.seat.id\n"
                        + "where CarriageTrainEntity_id=" + id;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {

                        SeatEntity seatEntity = new SeatEntity();
                        seatEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        seatEntity.setSeatName(rs.getObject(2).toString());
                        seatEntity.setStatus(true);
                        entitys.add(seatEntity);
                    }
                }
            }
        }
        return entitys;
    }

    public SeatEntity findSeatBySeatID(int id) throws ClassNotFoundException, SQLException {
        ConectionDB conectionDB = new ConectionDB();
        SeatEntity seatEntity;
        try (Connection conn = conectionDB.connection()) {
            seatEntity = new SeatEntity();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM datvetau.seat where id=" + id;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        seatEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        seatEntity.setSeatName(rs.getObject(2).toString());
                        seatEntity.setStatus(true);
                    }
                }
            }
        }
        return seatEntity;

    }
}
