package com.certiware.devinfoboard.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import com.certiware.devinfoboard.model.User;
import com.certiware.devinfoboard.repository.UserRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    

    public void createUser(String stringUserJSON) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper jsonMapper = new ObjectMapper();

        //Read Json String
        JsonNode jsonUsers = jsonMapper.readTree(stringUserJSON);

            ArrayList<User> users = new ArrayList<>();

            for(JsonNode jsonUser : jsonUsers){
                User user = jsonMapper.readValue(jsonUser.toString(), User.class);

                users.add(user);            
            
        }

        userRepository.saveAll(users);
    }

    //모든 유저 정보 가져오기
    public String getAllUsers() {
        ObjectMapper jsonMapper = new ObjectMapper();

        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        String stringUserJSON = "";
        try{
            stringUserJSON = jsonMapper.writeValueAsString(users);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }

        System.out.println(stringUserJSON);

        return stringUserJSON;
    }

        //모든 유저 정보 가져오기
        public ArrayList<User> getAllUsersForJstl() {
            // ObjectMapper jsonMapper = new ObjectMapper();
    
            ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
            // String stringUserJSON = "";
            // try{
            //     stringUserJSON = jsonMapper.writeValueAsString(users);
            // }catch(JsonProcessingException e){
            //     e.printStackTrace();
            // }
    
            System.out.println(users.toString());
    
            return users;
        }


    //한개의 유저만 가져오기
    public String getUser(int id){
        ObjectMapper jsonMapper = new ObjectMapper();

        String stringUserJSON = null; 
        try{
            Optional<User> users = userRepository.findById(id);

            stringUserJSON = jsonMapper.writeValueAsString(users.orElse(null));
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        System.out.println(stringUserJSON);

        return stringUserJSON;
    }


    //한명만 수정
    public String updateUser(String stringUserJSON) throws JsonMappingException, JsonProcessingException {
        ObjectMapper jsonMapper = new ObjectMapper();
        User user = jsonMapper.readValue(stringUserJSON, User.class);

        return jsonMapper.writeValueAsString(userRepository.saveAndFlush(user));

    }




    //모두 삭제

    public void deleteUsers() {
        userRepository.deleteAll();
    }



    //한개만 삭제
    public void deleteUser(int id){


        userRepository.deleteById(id);
    }
    


    public String getUserByName(String name){
        ObjectMapper jsonMapper = new ObjectMapper();

        ArrayList<User> users = (ArrayList<User>) userRepository.findByNameContaining(name);
        String userJSON = null;
        try{
            if(!users.isEmpty()){
            userJSON = jsonMapper.writeValueAsString(users);
            }
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        System.out.println(userJSON);

        return userJSON;
    }





}
