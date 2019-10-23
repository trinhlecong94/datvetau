package com.mycompany.datvetau.service;

import com.mycompany.datvetau.entities.NhaGaEntity;
import com.mycompany.datvetau.repository.GheNgoiRepository;
import com.mycompany.datvetau.repository.NhaGaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class NhaGaService {

    @Autowired
    private NhaGaRepository nhaGaRepository;

    public List<NhaGaEntity> getNhaGas() {
        return (List<NhaGaEntity>) nhaGaRepository.findAll();
    }

}
