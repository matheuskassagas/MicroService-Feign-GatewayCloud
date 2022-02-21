package com.devms.hroauth.controller;

import com.devms.hroauth.entity.User;
import com.devms.hroauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail (@RequestParam String email){
        try{
            User user = service.findByEmail(email);
            return ResponseEntity.ok().body(user);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
