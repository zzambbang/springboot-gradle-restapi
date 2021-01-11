package com.certiware.devinfoboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "authusers")
@Getter
@Setter
@ToString
public class AuthUser {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authuser_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "apikey_id")
    private ApiKey apikey;

}
