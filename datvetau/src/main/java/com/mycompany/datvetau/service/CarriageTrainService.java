package com.mycompany.datvetau.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.mycompany.datvetau.repository.CarriageTrainRepository;

@Service
public class CarriageTrainService {

    @Autowired
    private CarriageTrainRepository carriageTrainRepository;

}
