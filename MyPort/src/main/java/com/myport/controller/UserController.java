package com.myport.controller;

import com.myport.domain.UserVo;
import com.myport.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@Log4j
@RequestMapping("/user/*")
@AllArgsConstructor
public class UserController {

    private UserService service;

    @GetMapping("/login")
    public void login(){}

    @PostMapping("/login")
    public String login(UserVo user, RedirectAttributes rttr){
        Map<String,String> result = service.login(user);
        rttr.addFlashAttribute("result",result.get("result"));
        return result.get("url");
    }

    @GetMapping("/register")
    public void register(){}

    @PostMapping("/register")
    public String register(UserVo user, RedirectAttributes rttr){
        String result = service.registerUser(user);
        return result;
    }

}
