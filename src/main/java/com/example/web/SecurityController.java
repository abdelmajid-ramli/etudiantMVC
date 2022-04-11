package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {
    @GetMapping("/403")
    public String notAuthorized(){
        return"403";
    }
    
    
    /*
    @GetMapping("/login")
    public String login() {
    	return "login";
    }*/
}
