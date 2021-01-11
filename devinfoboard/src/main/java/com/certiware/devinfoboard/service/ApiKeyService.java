package com.certiware.devinfoboard.service;

import com.certiware.devinfoboard.repository.ApikeyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyService {
    
    @Autowired
    ApikeyRepository apikeyRepository;
}
