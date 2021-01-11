package com.certiware.devinfoboard.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import com.certiware.devinfoboard.model.AuthUser;
import com.certiware.devinfoboard.repository.AuthUserRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Controller가 Request를 받으면 적절한 Service에 전달하고, 
//전달 받은 Service는 비즈니스 로직을 처리한다. 
//DAO로 데이터베이스를 접근하고, DTO로 데이터를 전달받은 다음, 적절한 처리를 해 반환한다. 

@Service
public class AuthUserService {
    
    @Autowired
    AuthUserRepository authUserRepository;

    //authUser 생성
    public void createAuthUser(String stringAuthUserJSON) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper jsonMapper = new ObjectMapper();

        //Read JSON String
        JsonNode jsonUsers = jsonMapper.readTree(stringAuthUserJSON);

            ArrayList<AuthUser> authusers = new ArrayList<>();

        for(JsonNode jsonUser : jsonUsers){
            AuthUser authuser = jsonMapper.readValue(jsonUser.toString(), AuthUser.class);

            authusers.add(authuser);
    }

    authUserRepository.saveAll(authusers);
}


    //모든 authusers 가져오기
    public String getAllAuthUsers(){
        ObjectMapper jsonMapper = new ObjectMapper();

        ArrayList<AuthUser> authusers = (ArrayList<AuthUser>) authUserRepository.findAll();
        String stringAuthUserJSON = "";
        try{
            stringAuthUserJSON = jsonMapper.writeValueAsString(authusers);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }

        System.out.println(stringAuthUserJSON);

        return stringAuthUserJSON;
    }
    
    //get one authuser
    public String getAuthUser(int authuser_id){
        ObjectMapper jsonMapper = new ObjectMapper();

        String stringAuthUserJSON = null;
        try{
            Optional<AuthUser> authusers = authUserRepository.findById(authuser_id);
            
            stringAuthUserJSON = jsonMapper.writeValueAsString(authusers.orElse(null));
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        System.out.println(stringAuthUserJSON);

        return stringAuthUserJSON;
    }

    //update one authuser
    public String updateAuthUser(String stringAuthUserJSON)throws JsonMappingException, JsonProcessingException {
        ObjectMapper jsonMapper = new ObjectMapper();
        AuthUser authuser = jsonMapper.readValue(stringAuthUserJSON, AuthUser.class);

        return jsonMapper.writeValueAsString(authUserRepository.saveAndFlush(authuser));
    }

    public void deleteAuthUsers() {
        authUserRepository.deleteAll();
    }


	public void deleteAuthUser(int authuser_id) {
        authUserRepository.deleteById(authuser_id);
	}
    






}