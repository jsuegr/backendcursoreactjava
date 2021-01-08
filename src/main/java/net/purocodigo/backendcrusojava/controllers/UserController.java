package net.purocodigo.backendcrusojava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {
    

    @GetMapping
    public String getUser(){
        return "get user details";
    }

    @PostMapping
    public String createUser(){
        return "create new user";
    }
}
