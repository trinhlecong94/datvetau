package com.mycompany.datvetausever.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.ParseException;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
        Socket socket;
        try (ServerSocket ss = new ServerSocket(7777)) {
            while (true) {
                try {
                    socket = ss.accept();
                    //System.out.println("Client accepted: " + socket);
                    ThreadServer t1 = new ThreadServer(socket);
                    t1.start();
                } catch (IOException e) {
                    //System.err.println(" Connection Error: " + e);
                }
            }
        }
    }
}
