package com.mycompany.datvetau.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.mycompany.datvetau.repository.TrainArrivalTimeRepository;

@Service
public class TrainArrivalTimeService {

    @Autowired
    private TrainArrivalTimeRepository trainArrivalTimeRepository;

}
