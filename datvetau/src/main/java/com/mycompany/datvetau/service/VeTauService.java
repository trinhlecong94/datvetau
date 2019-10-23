package com.mycompany.datvetau.service;

import com.mycompany.datvetau.repository.VeTauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeTauService {

    @Autowired
    private VeTauRepository tauRepository;

}
