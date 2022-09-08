package dev.titans.controllers;

import dev.titans.dtos.LoginCredentials;
import dev.titans.services.JwtService;
import dev.titans.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginCredentials loginCredentials){
        return loginService.authenticateUser(loginCredentials);
    }


}
