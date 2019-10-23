package com.mycompany.datvetau.service;

import com.mycompany.datvetau.repository.QuanTriVienRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class QuanTriVienService {

    @Autowired
    private QuanTriVienRepository quanTriVienRepository;

}
