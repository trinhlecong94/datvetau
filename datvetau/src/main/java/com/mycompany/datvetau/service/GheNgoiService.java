package com.mycompany.datvetau.service;

import com.mycompany.datvetau.repository.GheNgoiRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class GheNgoiService {

    @Autowired
    private GheNgoiRepository gheNgoiRepository;
 
}
