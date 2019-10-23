package com.mycompany.datvetau.service;

import com.mycompany.datvetau.entities.TauEntity;
import com.mycompany.datvetau.repository.TauRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TauService {

    @Autowired
    private TauRepository tauRepository;

    public List<TauEntity> getTaus() {
        return (List<TauEntity>) tauRepository.findAll();
    }

}
