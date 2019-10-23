package com.mycompany.datvetau.service;

import com.mycompany.datvetau.repository.GioTauChayRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class GioTauChayService {

    @Autowired
    private GioTauChayRepository gioTauChayRepository;

}
