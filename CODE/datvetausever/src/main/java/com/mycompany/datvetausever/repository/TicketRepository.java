package com.mycompany.datvetausever.repository;

import com.mycompany.datvetausever.conection.ConectionDB;
import com.mycompany.datvetausever.entities.TicketEntity;
import com.mycompany.datvetausever.service.SeatService;
import com.mycompany.datvetausever.service.StationService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketRepository {

    public List<TicketEntity> findTicketsByDateAndSeat(Date departureTime, int id) throws ClassNotFoundException, SQLException, ParseException {
        ConectionDB conectionDB = new ConectionDB();
        List<TicketEntity> ticketEntitys;
        try (Connection conn = conectionDB.connection()) {
            ticketEntitys = new ArrayList<>();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM datvetau.ticket where \n"
                        + "departureTime='" + departureTime.toString() + "' \n"
                        + "and seat_id=" + id;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        TicketEntity ticketEntity = new TicketEntity();
                        ticketEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        ticketEntity.setCode(rs.getObject(2).toString());
                        ticketEntity.setDepartureTime(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getObject(3).toString()));
                        ticketEntity.setFullName(rs.getObject(4).toString());
                        ticketEntity.setIdentityNumber(rs.getObject(5).toString());
                        StationService stationService = new StationService();
                        ticketEntity.setFromSation(stationService.findStationByID(Integer.parseInt(rs.getObject(6).toString())));
                        ticketEntity.setToStation(stationService.findStationByID(Integer.parseInt(rs.getObject(8).toString())));
                        SeatService seatService = new SeatService();
                        seatService.findSeatBySeatID(Integer.parseInt(rs.getObject(8).toString()));
                        ticketEntitys.add(ticketEntity);
                    }
                }
            }
        }
        return ticketEntitys;
    }

    synchronized public static int insertTicket(String departureTime, String fullName, int identityNumber,
            int fromSation_id, int seat_id, int toStation_id) throws ClassNotFoundException, SQLException, ParseException, InterruptedException {
        ConectionDB conectionDB = new ConectionDB();
        int code;
        try (Connection conn = conectionDB.connection()) {
            code = (int) ((Math.random() * ((999999999 - 100000000) + 1)) + 100000000);
            while (findTicketByCode(code).getCode() != null) {
                code = (int) ((Math.random() * ((999999999 - 100000000) + 1)) + 100000000);
            }
            String sql = "INSERT INTO `datvetau`.`ticket` (`code`, `departureTime`, `fullName`, `identityNumber`, `fromSation_id`, `seat_id`, `toStation_id`) "
                    + "VALUES ('"
                    + code + "', '"
                    + departureTime + "', '"
                    + fullName + "', '"
                    + identityNumber + "', '"
                    + fromSation_id + "', '"
                    + seat_id + "', '"
                    + toStation_id + "'"
                    + ")";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        for (int i = 1; i < 10; i++) {
            Thread.sleep(500);
            System.out.println(i);
        }
        return code;
    }

    public static TicketEntity findTicketByCode(int code) throws ClassNotFoundException, SQLException, ParseException {
        ConectionDB conectionDB = new ConectionDB();
        TicketEntity ticketEntity;
        try (Connection conn = conectionDB.connection()) {
            ticketEntity = new TicketEntity();
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM datvetau.ticket where code=" + code;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        ticketEntity.setId(Integer.parseInt(rs.getObject(1).toString()));
                        ticketEntity.setCode(rs.getObject(2).toString());
                        ticketEntity.setDepartureTime(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getObject(3).toString()));
                        ticketEntity.setFullName(rs.getObject(4).toString());
                        ticketEntity.setIdentityNumber(rs.getObject(5).toString());

                        StationService stationService = new StationService();
                        ticketEntity.setFromSation(stationService.findStationByID(Integer.parseInt(rs.getObject(6).toString())));

                        ticketEntity.setToStation(stationService.findStationByID(Integer.parseInt(rs.getObject(8).toString())));

                        SeatService seatService = new SeatService();
                        seatService.findSeatBySeatID(Integer.parseInt(rs.getObject(8).toString()));
                    }
                }
            }
        }
        return ticketEntity;
    }

}
