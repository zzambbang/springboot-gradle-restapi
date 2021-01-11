package com.certiware.devinfoboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class ApiKey {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int apikey_id;

    private String token;
    
}
