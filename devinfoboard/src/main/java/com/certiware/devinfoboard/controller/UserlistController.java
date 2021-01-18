package com.certiware.devinfoboard.controller;

import com.certiware.devinfoboard.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserlistController {

    @RequestMapping("/userlist")
    public ModelAndView userList(){
        ModelAndView view = new ModelAndView();

        User user = new User();

        user.setUser_id(15);
        user.setName("jjw");
        user.setEmail("jjw@kakao.com");

        view.setViewName("userlist"); //이동할 페이지 설정

        return view;

    }
    
}

