package com.certiware.devinfoboard.controller;

import java.io.IOException;

import com.certiware.devinfoboard.service.UserService;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllUsers(){
        return userService.getAllUsers();
    }

    
    //create user
    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody String stirngUserJSON)
            throws JsonParseException, JsonMappingException, IOException{
        userService.createUser(stirngUserJSON);

        return stirngUserJSON;
    }

     //update user
     @PutMapping(value = "/user/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
     public String updateUser(@PathVariable int user_id, @RequestBody String stringUserJSON)
             throws JsonParseException, JsonMappingException, IOException {
 
        userService.updateUser(stringUserJSON);
        
        return stringUserJSON;

     }
 
    //get user
    @GetMapping(value="/user/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser(@PathVariable int user_id) {

        return userService.getUser(user_id);
    }
    
    //delete user
    @DeleteMapping(value = "/user/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable int user_id) {

        userService.deleteUser(user_id);

        // return id + "삭제 완료.";
    }

    //delete all user
    @DeleteMapping (value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUsers(){

        userService.deleteUsers();

		return "삭제완료";
	}
    
    //search 하기
    @GetMapping(value = "/user", params = "name", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUserByName(@RequestParam(value = "name") String name){
	   return userService.getUserByName(name);
    }
    
}
