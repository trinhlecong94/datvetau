package com.mycompany.datvetausever.service;

import com.mycompany.datvetausever.entities.TicketEntity;
import com.mycompany.datvetausever.repository.TicketRepository;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class TicketService {

    TicketRepository ticketRepository = new TicketRepository();

    public List<TicketEntity> findTicketsByDateAndSeat(Date departureTime, int id) throws ClassNotFoundException, SQLException, ParseException {
        return ticketRepository.findTicketsByDateAndSeat(departureTime, id);
    }

    public int insertTicket(String departureTime, String fullName, int identityNumber,
            int fromSation_id, int seat_id, int toStation_id) throws ClassNotFoundException, SQLException, ParseException, InterruptedException {
        return TicketRepository.insertTicket(departureTime, fullName, identityNumber,
                fromSation_id, seat_id, toStation_id);
    }

}
