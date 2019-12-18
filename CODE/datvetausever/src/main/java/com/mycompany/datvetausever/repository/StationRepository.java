package com.mycompany.datvetausever.repository;

import com.mycompany.datvetausever.conection.ConectionDB;
import com.mycompany.datvetausever.entities.StationEntity;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StationRepository implements Serializable {

    public List<StationEntity> findAllStation() throws ClassNotFoundException, SQLException {
        ConectionDB conectionDB = new ConectionDB();
        List<StationEntity> entitys;
        try (Connection conn = conectionDB.connection()) {
            entitys = new ArrayList<>();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM datvetau.sation";
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        StationEntity stationEntity = new StationEntity();
                        stationEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        stationEntity.setAddress(rs.getObject(2).toString());
                        stationEntity.setStationName(rs.getObject(3).toString());
                        entitys.add(stationEntity);
                    }
                }
            }
        }
        return entitys;
    }

    public StationEntity findStationByID(int id) throws ClassNotFoundException, SQLException {
        ConectionDB conectionDB = new ConectionDB();
        StationEntity stationEntity;
        try (Connection conn = conectionDB.connection()) {
            stationEntity = new StationEntity();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM datvetau.sation where id=" + id;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        stationEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        stationEntity.setAddress(rs.getObject(2).toString());
                        stationEntity.setStationName(rs.getObject(3).toString());
                    }
                }
            }
        }
        return stationEntity;
    }

    public StationEntity findStationByName(String stationName) throws ClassNotFoundException, SQLException {
        ConectionDB conectionDB = new ConectionDB();
        StationEntity stationEntity;
        try (Connection conn = conectionDB.connection()) {
            stationEntity = new StationEntity();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM datvetau.sation where stationName='" + stationName + "'";
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        stationEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        stationEntity.setAddress(rs.getObject(2).toString());
                        stationEntity.setStationName(rs.getObject(3).toString());
                    }
                }
            }
        }
        return stationEntity;
    }

}
