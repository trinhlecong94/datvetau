package com.mycompany.datvetau.service;

import com.mycompany.datvetau.entities.LichTrinhEntity;
import com.mycompany.datvetau.repository.LichTrinhRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class LichTrinhService {

    @Autowired
    private LichTrinhRepository lichTrinhRepository;

    public List<LichTrinhEntity> getLichTrinhs() {
        return (List<LichTrinhEntity>) lichTrinhRepository.findAll();
    }

}
