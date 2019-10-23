package com.mycompany.datvetau.service;

import com.mycompany.datvetau.repository.ToaTauRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ToaTauService {

    @Autowired
    private ToaTauRepository toaTauRepository;

}
