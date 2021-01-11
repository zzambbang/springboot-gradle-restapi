package com.certiware.devinfoboard.repository;

import com.certiware.devinfoboard.model.AuthUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer>{
    
}
