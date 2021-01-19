package com.certiware.devinfoboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "users")
public class User {
    //DAO + DTO와 같은 역할 ..
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    private String name;

    private String email;

}

// public class User {

//     private int user_id;
//     private String name;
//     private String email;

//     public int getUser_id() {
//         return user_id;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public void setUser_id(int user_id) {
//         this.user_id = user_id;
//     }

//     @Override
//     public String toString(){
//         return "User [user_id=" + user_id + ", name=" + name + ", email =" + email + "]" ;
//     }

// }