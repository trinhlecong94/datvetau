package com.mycompany.datvetau.service;

import com.mycompany.datvetau.repository.TrangThaiGheRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TrangThaiGheService {

    @Autowired
    private TrangThaiGheRepository trangThaiGheRepository;

}
