package com.certiware.devinfoboard.repository;

import com.certiware.devinfoboard.model.ApiKey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApikeyRepository extends JpaRepository<ApiKey, Integer> {
    
}
