package com.mycompany.datvetau.service;

import com.mycompany.datvetau.entities.SeatEntity;
import com.mycompany.datvetau.entities.TicketEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.datvetau.repository.TicketRepository;
import java.util.Date;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<TicketEntity> findAllTicketByCode(String code) {
        return ticketRepository.findAllTicketByCode(code);
    }

    public TicketEntity saveTicket(TicketEntity ticket) {
        return ticketRepository.save(ticket);
    }

    public List<TicketEntity> findAllTicketByDateAndSeat(Date departureTime, SeatEntity seat) {
        return ticketRepository.findAllTicketByDateAndSeat(departureTime, seat);
    }
}
