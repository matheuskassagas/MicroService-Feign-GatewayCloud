package com.devms.hruser.service;

import com.devms.hruser.repository.entity.User;
import com.devms.hruser.repository.UserRepository;
import com.devms.hruser.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Long id) throws Exception {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User findByEmail (String email) {
        Optional<User> user = Optional.ofNullable(repository.findByEmail(email));
        return user.orElseThrow(() -> new ResourceNotFoundException(email));
    }
}
