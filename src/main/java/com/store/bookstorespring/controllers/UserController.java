package com.store.bookstorespring.controllers;

import com.store.bookstorespring.entities.User;
import com.store.bookstorespring.repositories.UserRepository;
import com.store.bookstorespring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public void getUsers(){
        userService.getAllUsers();
    }


}
