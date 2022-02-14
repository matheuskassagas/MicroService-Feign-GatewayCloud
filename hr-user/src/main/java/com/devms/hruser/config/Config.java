package com.devms.hruser.config;

import com.devms.hruser.entity.Role;
import com.devms.hruser.entity.User;
import com.devms.hruser.repository.RoleRepository;
import com.devms.hruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Nina Brown", "nina@gmail.com", "$2a$10$NYANZA/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu");
        User user2 = new User("Leia Red", "leia@gmail.com", "$2a$10$NYANZA/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu");

        Role role1 = new Role(null,"ROLE_OPERATOR");
        Role role2 = new Role(null, "ROLE_ADMIN");

        roleRepository.saveAll(Arrays.asList(role1, role2));

        user1.getRoles().add(role1);
        user2.getRoles().add(role1);
        user2.getRoles().add(role2);



        userRepository.saveAll(Arrays.asList(user1, user2));

    }
}
