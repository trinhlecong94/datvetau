package com.mycompany.datvetau.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.mycompany.datvetau.repository.AdministratorsRepository;

@Service
public class AdministratorsService {

    @Autowired
    private AdministratorsRepository administratorsRepository;

}
