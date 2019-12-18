package com.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDDatabase {

    private static Connection conn;

    public static void CRUDDatabase() throws ClassNotFoundException, SQLException {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "root");
        CRUDDatabase.conn = con;
    }

    synchronized public static String buyTicket(int seatID) throws SQLException, InterruptedException {
        Statement stmt = conn.createStatement();
        boolean isExist = IsExistDatabase(seatID);
        for (int i = 1; i < 10; i++) {
            Thread.sleep(500);
            System.out.println(i);
        }
        if (isExist) {
            return "That Bai";
        }
        String SQL = "Update seat_status SET status = 'exist' WHERE seat = " + seatID;
        int rs = stmt.executeUpdate(SQL);
        return "Thanh Cong";
    }

    public static String selectDatabase() {
        String seat = "";
        try (Statement stmt = conn.createStatement()) {
            String sql3 = "SELECT * FROM seat_status";
            try (ResultSet rs = stmt.executeQuery(sql3)) {
                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                    seat = seat + " " + rs.getObject(1) + ": " + rs.getObject(2) + ", ";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return seat;
    }

    public static boolean IsExistDatabase(int seatid) {
        String seat = "";
        try (Statement stmt = conn.createStatement()) {
            String sql3 = "SELECT * FROM seat_status where seat=" + seatid;
            try (ResultSet rs = stmt.executeQuery(sql3)) {
                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                    if (rs.getObject(2).equals("empty")) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
