package com.myport.controller;

import com.myport.domain.UserVo;
import com.myport.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
@RequestMapping("/user/*")
@AllArgsConstructor
public class UserController {

    private UserService service;

    /*
    @PostMapping ("/register")
    public String register(UserVo user){
        service.registerUser(user);

    }
    */
}
