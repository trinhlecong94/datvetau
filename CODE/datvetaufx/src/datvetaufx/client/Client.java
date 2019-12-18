package datvetaufx.client;

import com.mycompany.datvetausever.entities.CarriageTrainEntity;
import com.mycompany.datvetausever.entities.SeatEntity;
import com.mycompany.datvetausever.entities.StationEntity;
import com.mycompany.datvetausever.entities.TrainEntity;
import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static List<StationEntity> findStations() throws ClassNotFoundException, SQLException, IOException {
        List<StationEntity> stations = null;
        try (Socket socket = new Socket("localhost", 7777)) {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject("findStations");

            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            stations = (List<StationEntity>) objectInputStream.readObject();
            socket.close();
        }
        return stations;
    }

    public static TrainEntity findTrains(String toStation, String fromStation, String departureDate, String train) throws ClassNotFoundException, SQLException, IOException {
        TrainEntity trainEntity = null;
        try (Socket socket = new Socket("localhost", 7777)) {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject("findTrains");

            objectOutputStream.writeObject(toStation);
            objectOutputStream.writeObject(fromStation);
            objectOutputStream.writeObject(departureDate);
            objectOutputStream.writeObject(train);

            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            trainEntity = (TrainEntity) objectInputStream.readObject();
            socket.close();
        }

        return trainEntity;
    }

    public static List<CarriageTrainEntity> findCarriageTrains() throws ClassNotFoundException, SQLException, IOException {
        List<CarriageTrainEntity> scheduleEntitys = null;
        return scheduleEntitys;
    }

    public static List<SeatEntity> findSeats() throws ClassNotFoundException, SQLException, IOException {
        List<SeatEntity> scheduleEntitys = null;
        return scheduleEntitys;
    }

    public static int insertTicket(String departureTime, String fullName, int identityNumber,
            String fromSationName, int seat_id, String toStationName) throws ClassNotFoundException, SQLException, IOException {
        int code = 0;
        try (Socket socket = new Socket("localhost", 7777)) {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject("insertTicket");

            objectOutputStream.writeObject(departureTime);
            objectOutputStream.writeObject(fullName);
            objectOutputStream.writeObject(identityNumber);
            objectOutputStream.writeObject(fromSationName);
            objectOutputStream.writeObject(seat_id);
            objectOutputStream.writeObject(toStationName);

            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            code = (int) objectInputStream.readObject();
            socket.close();
        }
        return code;
    }

    public static List<TrainEntity> sendValueToSever(String toStation, String fromStation, String departureDate) throws ClassNotFoundException, SQLException, IOException {
        List<TrainEntity> check = new ArrayList<>();
        try (Socket socket = new Socket("localhost", 7777)) {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject("sendValueToSever");

            objectOutputStream.writeObject(toStation);
            objectOutputStream.writeObject(fromStation);
            objectOutputStream.writeObject(departureDate);

            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            check = (List<TrainEntity>) objectInputStream.readObject();
            socket.close();
        }
        return check;
    }

}
