package com.devms.hruser.controller;

import com.devms.hruser.repository.entity.User;

import com.devms.hruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

        @Autowired
        private UserService userService;

        @GetMapping(value = "/{id}")
        public ResponseEntity<User> findById(@PathVariable Long id) throws Exception {
            User obj = userService.findById(id);
            return ResponseEntity.ok().body(obj);
        }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) throws Exception {
        User obj = userService.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

}
