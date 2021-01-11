package com.certiware.devinfoboard.controller;

import java.io.IOException;

import com.certiware.devinfoboard.service.AuthUserService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthUserController {
    
    @Autowired
    private AuthUserService authUserService;
     //get all authusers
     @GetMapping(value = "/authusers", produces = MediaType.APPLICATION_JSON_VALUE)
     public String getAllAuthUsers(){
         return authUserService.getAllAuthUsers();
     }
     
 
     //create authusers
     @PostMapping(value = "/authusers", produces = MediaType.APPLICATION_JSON_VALUE)
     public String createAuthUser(@RequestBody String stringAuthUserJSON)
         throws JsonParseException, JsonMappingException, IOException{
             authUserService.createAuthUser(stringAuthUserJSON);
 
             return stringAuthUserJSON;
         }
 
     //update authuser
     @PutMapping(value = "/authuser/{authuser_id}", produces = MediaType.APPLICATION_JSON_VALUE)
      public String updateUser(@PathVariable int user_id, @RequestBody String stringAuthUserJSON)
              throws JsonParseException, JsonMappingException, IOException {
  
         authUserService.updateAuthUser(stringAuthUserJSON);
         
         return stringAuthUserJSON;
 
      }
 
     @GetMapping(value = "/authuser/{authuser_id}",produces = MediaType.APPLICATION_JSON_VALUE)
     public String getAuthUser(@PathVariable int authuser_id){
 
         return authUserService.getAuthUser(authuser_id);
     }
 
     //delete one authuser
     @DeleteMapping(value = "/authuser/{authuser_id}",produces = MediaType.APPLICATION_JSON_VALUE)
     public String deleteAuthUser(@PathVariable int authuser_id){
 
         authUserService.deleteAuthUser(authuser_id);
 
         return "삭제 완료.";
     }
 
     @DeleteMapping(value = "/authusers", produces = MediaType.APPLICATION_JSON_VALUE)
     public String deleteAuthUser(){
         
         authUserService.deleteAuthUsers();
 
         return "삭제 완료.";
     }
 



}
