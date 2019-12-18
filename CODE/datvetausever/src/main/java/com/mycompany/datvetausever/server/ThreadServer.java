package com.mycompany.datvetausever.server;

import com.mycompany.datvetausever.entities.CarriageTrainEntity;
import com.mycompany.datvetausever.entities.ScheduleEntity;
import com.mycompany.datvetausever.entities.SeatEntity;
import com.mycompany.datvetausever.entities.StationEntity;
import com.mycompany.datvetausever.entities.TicketEntity;
import com.mycompany.datvetausever.entities.TrainArrivalTimeEntity;
import com.mycompany.datvetausever.entities.TrainEntity;
import com.mycompany.datvetausever.service.ScheduleService;
import com.mycompany.datvetausever.service.SeatService;
import com.mycompany.datvetausever.service.StationService;
import com.mycompany.datvetausever.service.TicketService;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
        } catch (IOException | ClassNotFoundException | SQLException | InterruptedException | ParseException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void responsClient(Socket socket) throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException, ParseException {
        //System.out.println("ServerSocket awaiting connections...");
        //System.out.println("Connection from " + socket + "!");
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        String message = (String) objectInputStream.readObject();

        switch (message) {
            case "findStations":
                List<StationEntity> stations = (new StationService()).findAllStation();
                objectOutputStream.writeObject(stations);
                break;
            case "findTrains":
                String toStation1 = (String) objectInputStream.readObject();
                String fromStation1 = (String) objectInputStream.readObject();
                String departureDate1 = (String) objectInputStream.readObject();
                objectOutputStream.writeObject(chooseTicket(fromStation1, toStation1, departureDate1));
                break;
            case "findCarriageTrains":
                break;
            case "findSeats":
                break;
            case "insertTicket":
                String departureDateT = (String) objectInputStream.readObject();
                String fullName = (String) objectInputStream.readObject();
                int identityNumber = (int) objectInputStream.readObject();

                StationService stationService = new StationService();

                String fromSationName = (String) objectInputStream.readObject();
                int fromSation_id = stationService.findStationByName(fromSationName).getId();

                int seat_id = (int) objectInputStream.readObject();

                String toStationName = (String) objectInputStream.readObject();
                int toStation_id = stationService.findStationByName(toStationName).getId();

                TicketService service = new TicketService();
                if (!checkTicket(fromSationName, toStationName, departureDateT, seat_id)) {
                    objectOutputStream.writeObject(0);
                }
                int code = service.insertTicket(departureDateT, fullName, identityNumber, fromSation_id, seat_id, toStation_id);

                objectOutputStream.writeObject(code);
                break;
            case "sendValueToSever":
                String toStation = (String) objectInputStream.readObject();
                String fromStation = (String) objectInputStream.readObject();
                String departureDate = (String) objectInputStream.readObject();
                objectOutputStream.writeObject(getTrains(fromStation, toStation, departureDate));
                break;
            default:
                break;
        }
        socket.close();
    }

    public static List<TrainEntity> getTrains(String fromStation, String toStation, String departureDate) throws ClassNotFoundException, SQLException, ParseException {
        ScheduleService scheduleService = new ScheduleService();
        List<ScheduleEntity> scheduleEntity = scheduleService.findSchedulesByDate(java.sql.Date.valueOf(departureDate));

        List<TrainEntity> trains = new ArrayList<>();
        for (ScheduleEntity schedule : scheduleEntity) {
            List<TrainArrivalTimeEntity> trainArrivalTimes = schedule.getTrain().getTrainArrivalTime();
            int temp = 0;
            int index = 1;
            int noFromStation = Integer.MAX_VALUE;
            int noToStation = Integer.MIN_VALUE;
            for (TrainArrivalTimeEntity trainArrivalTime : trainArrivalTimes) {
                if (trainArrivalTime.getStation().getStationName() == null ? fromStation == null : trainArrivalTime.getStation().getStationName().equals(fromStation)) {
                    temp += 1;
                    noFromStation = index;
                }
                if (trainArrivalTime.getStation().getStationName() == null ? toStation == null : trainArrivalTime.getStation().getStationName().equals(toStation)) {
                    temp += 1;
                    noToStation = index;
                }
                index += 1;
            }
            if (noFromStation < noToStation) {
                trains.add(schedule.getTrain());
            }
        }
        return trains;
    }

    public static TrainEntity chooseTicket(String fromStation, String toStation, String departureDate) throws ClassNotFoundException, SQLException, ParseException {

        int trainID = 1;
        // tìm tàu thỏa điều kiện có ga đến và đi
        ScheduleService scheduleService = new ScheduleService();
        List<ScheduleEntity> scheduleEntity = scheduleService.findSchedulesByDateAndTrain(java.sql.Date.valueOf(departureDate), trainID);
        TrainEntity train = new TrainEntity();

        for (ScheduleEntity schedule : scheduleEntity) {
            List<TrainArrivalTimeEntity> trainArrivalTimes = schedule.getTrain().getTrainArrivalTime();
            int temp = 0;
            int index = 1;
            int noFromStation = Integer.MAX_VALUE;
            int noToStation = Integer.MIN_VALUE;

            for (TrainArrivalTimeEntity trainArrivalTime : trainArrivalTimes) {

                if (trainArrivalTime.getStation().getStationName() == null ? fromStation == null : trainArrivalTime.getStation().getStationName().equals(fromStation)) {
                    temp += 1;
                    noFromStation = index;
                }

                if (trainArrivalTime.getStation().getStationName() == null ? toStation == null : trainArrivalTime.getStation().getStationName().equals(toStation)) {
                    temp += 1;
                    noToStation = index;
                }
                index += 1;
            }

            if (noFromStation < noToStation) {
                List<CarriageTrainEntity> carriageTrains = schedule.getTrain().getCarriageTrains();
                for (CarriageTrainEntity carriageTrain : carriageTrains) {
                    List<SeatEntity> seats = carriageTrain.getSeats();
                    for (SeatEntity seat : seats) {
                        seat.setStatus(true);
                        TicketService ticketService = new TicketService();
                        List<TicketEntity> tickets = ticketService.findTicketsByDateAndSeat(java.sql.Date.valueOf(departureDate), seat.getId());
                        for (TicketEntity ticket : tickets) {

                            int index_1 = 1;
                            int noFromStation_1 = Integer.MAX_VALUE;
                            int noToStation_1 = Integer.MIN_VALUE;
                            for (TrainArrivalTimeEntity trainArrivalTime : trainArrivalTimes) {
                                if (trainArrivalTime.getStation().getStationName().equals(ticket.getFromSation().getStationName())) {
                                    noFromStation_1 = index_1;
                                }
                                if (trainArrivalTime.getStation().getStationName().equals(ticket.getToStation().getStationName())) {
                                    noToStation_1 = index_1;
                                }
                                index_1 += 1;
                            }

                            if (((noFromStation < noFromStation_1) && (noFromStation_1 < noToStation))
                                    || ((noFromStation < noToStation_1) && (noFromStation_1 < noToStation_1))) {
                                seat.setStatus(false);
                            }
                        }
                    }
                }
                train = schedule.getTrain();
            }
        }
        return train;
    }

    public static boolean checkTicket(String fromStation, String toStation, String departureDate, int seat_id) throws ClassNotFoundException, SQLException, ParseException {

        int trainID = 1;
        // tìm tàu thỏa điều kiện có ga đến và đi
        ScheduleService scheduleService = new ScheduleService();
        List<ScheduleEntity> scheduleEntity = scheduleService.findSchedulesByDateAndTrain(java.sql.Date.valueOf(departureDate), trainID);

        for (ScheduleEntity schedule : scheduleEntity) {
            List<TrainArrivalTimeEntity> trainArrivalTimes = schedule.getTrain().getTrainArrivalTime();
            int temp = 0;
            int index = 1;
            int noFromStation = Integer.MAX_VALUE;
            int noToStation = Integer.MIN_VALUE;

            for (TrainArrivalTimeEntity trainArrivalTime : trainArrivalTimes) {

                if (trainArrivalTime.getStation().getStationName() == null ? fromStation == null : trainArrivalTime.getStation().getStationName().equals(fromStation)) {
                    temp += 1;
                    noFromStation = index;
                }

                if (trainArrivalTime.getStation().getStationName() == null ? toStation == null : trainArrivalTime.getStation().getStationName().equals(toStation)) {
                    temp += 1;
                    noToStation = index;
                }
                index += 1;
            }

            if (noFromStation < noToStation) {

                SeatService seatService = new SeatService();
                SeatEntity seat = seatService.findSeatBySeatID(seat_id);
                TicketService ticketService = new TicketService();
                List<TicketEntity> tickets = ticketService.findTicketsByDateAndSeat(java.sql.Date.valueOf(departureDate), seat.getId());
                for (TicketEntity ticket : tickets) {

                    int index_1 = 1;
                    int noFromStation_1 = Integer.MAX_VALUE;
                    int noToStation_1 = Integer.MIN_VALUE;
                    for (TrainArrivalTimeEntity trainArrivalTime : trainArrivalTimes) {
                        if (trainArrivalTime.getStation().getStationName().equals(ticket.getFromSation().getStationName())) {
                            noFromStation_1 = index_1;
                        }
                        if (trainArrivalTime.getStation().getStationName().equals(ticket.getToStation().getStationName())) {
                            noToStation_1 = index_1;
                        }
                        index_1 += 1;
                    }

                    if (((noFromStation < noFromStation_1) && (noFromStation_1 < noToStation))
                            || ((noFromStation < noToStation_1) && (noFromStation_1 < noToStation_1))) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

}
