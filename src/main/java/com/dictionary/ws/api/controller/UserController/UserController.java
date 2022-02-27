package com.dictionary.ws.api.controller.UserController;

import com.dictionary.ws.business.abstracts.UserService;
import com.dictionary.ws.core.CustomAnnotation.CurrentUser;
import com.dictionary.ws.core.SecurityConfiguration.CustomUserDetails;
import com.dictionary.ws.entities.DTO.UserDTO;
import com.dictionary.ws.entities.DTO.UserUpdateDTO;
import com.dictionary.ws.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class UserController {


    @Autowired
    UserService userService;


    @GetMapping(path = "/x")
    public User  x(){
        User user =new User("kaan","qwe","ozdogan");

        return user;

    }

    @PostMapping(path = "/api/users")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user){


        return  ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
        //return  userService.saveUser(user);
    }


    @GetMapping(path = "/api/users")
    public Page<UserDTO> getUsers(Pageable pageable, @CurrentUser CustomUserDetails userDetails){

        return userService.getUsers(pageable,userDetails.getUser()).map((user) ->{
            return new UserDTO(user);
        } );
    }


    @GetMapping(path = "api/users/{username}")
    public UserDTO getUser(@PathVariable String username){

        return new UserDTO(userService.getByUserName(username));
    }


    @PutMapping(path="api/users/{username}")
    @PreAuthorize("#username==principal.username")
    UserDTO setUser(@RequestBody UserUpdateDTO userUpdateDTO,@PathVariable String username){

        return new UserDTO(userService.updateUser(userUpdateDTO,username));
    }





}
