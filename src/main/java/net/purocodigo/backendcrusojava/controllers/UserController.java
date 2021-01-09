package net.purocodigo.backendcrusojava.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.purocodigo.backendcrusojava.models.requests.UserDetailRequestModel;
import net.purocodigo.backendcrusojava.models.responses.UserRest;
import net.purocodigo.backendcrusojava.models.services.UserServiceInterface;
import net.purocodigo.backendcrusojava.models.shared.UserDto;

@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {
    
    @Autowired
    private UserServiceInterface userService;


    @GetMapping
    public String getUser(){
        return "get user details";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails){

        UserRest userToReturn =  new UserRest();
        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = this.userService.createUser(userDto);
        
        BeanUtils.copyProperties(createdUser, userToReturn);
        
        return userToReturn;
    }
}
