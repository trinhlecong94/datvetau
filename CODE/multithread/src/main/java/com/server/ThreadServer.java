package com.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServer extends Thread {

    private final Socket serverSocket;

    public ThreadServer(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            responsClient(serverSocket);
        } catch (IOException | ClassNotFoundException | SQLException | InterruptedException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void responsClient(Socket socket) throws IOException, ClassNotFoundException, SQLException, InterruptedException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        CRUDDatabase.CRUDDatabase();
        String choose = "";
        String seatID = "";
        while (true) {
            choose = in.readLine();
            if (choose.equals("1")) {
                CRUDDatabase crudd = new CRUDDatabase();
                out.println(CRUDDatabase.selectDatabase());
            }
            if (choose.equals("2")) {
                seatID = in.readLine();
                out.println(CRUDDatabase.buyTicket(Integer.parseInt(seatID)));
            }
            if (choose.equals("3")) {
                break;
            }
        }

    }
}
