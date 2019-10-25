package com.mycompany.datvetau.service;

import com.mycompany.datvetau.entities.VeTauEntity;
import com.mycompany.datvetau.repository.VeTauRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeTauService {

    @Autowired
    private VeTauRepository ticketRepository;

    public List<VeTauEntity> findAllTicketByCode(String maSo) {
        return ticketRepository.findAllTicketByCode(maSo);
    }
}
