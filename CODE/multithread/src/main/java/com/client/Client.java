package com.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 7;

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress addr = InetAddress.getByName(SERVER_IP);
        Socket socket = new Socket(addr, SERVER_PORT);
        try {
            System.out.println("Connected: " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            int choose,seatID;
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("1: KIEM TRA GHE TRONG :");
                System.out.println("2: CHON GHE           :");
                System.out.println("3: THOAT              :");
                
                choose = sc.nextInt();
                if (choose == 1) {
                    out.println("1");
                    System.out.println(in.readLine());
                }
                if (choose == 2) {
                    out.println("2");
                    seatID=sc.nextInt();
                    out.println(seatID);
                    System.out.println(in.readLine());
                }
                if (choose == 3) {
                    out.println("3");
                    break;
                }
            }

        } catch (IOException ie) {
            System.out.println("Can't connect to server");
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
