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

    synchronized public TicketEntity saveTicket(TicketEntity ticket) throws InterruptedException {
        System.out.println(Thread.currentThread().getId());
//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(1000);
//            System.out.println(i);
//        }
        return ticketRepository.save(ticket);
    }

    public List<TicketEntity> findAllTicketByDateAndSeat(Date departureTime, SeatEntity seat) {
        return ticketRepository.findAllTicketByDateAndSeat(departureTime, seat);
    }
}
