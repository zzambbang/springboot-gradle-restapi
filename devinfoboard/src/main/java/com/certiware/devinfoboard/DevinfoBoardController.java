package com.certiware.devinfoboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DevinfoBoardController {
    
    @GetMapping("/")
    public String main(){
        return "main";
    }
}
