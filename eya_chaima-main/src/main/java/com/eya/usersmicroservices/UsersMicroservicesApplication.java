package com.eya.usersmicroservices;

import com.eya.usersmicroservices.entities.Role;
import com.eya.usersmicroservices.entities.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.eya.usersmicroservices.service.UserService;

@SpringBootApplication
public class UsersMicroservicesApplication {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UsersMicroservicesApplication.class, args);
    }
/*
    @PostConstruct
    void init_users() {
        // Ajouter les rôles
        userService.addRole(new Role(null, "ADMIN"));
        userService.addRole(new Role(null, "USER"));

        // Ajouter les utilisateurs
        userService.saveUser(new User(null, "admin", "123", true, null));
        userService.saveUser(new User(null, "eya", "123", true, null));
        userService.saveUser(new User(null, "houssem", "123", true, null));

        // Associer les rôles aux utilisateurs
        userService.addRoleToUser("admin", "ADMIN");
        userService.addRoleToUser("admin", "USER");
        userService.addRoleToUser("eya", "USER");
        userService.addRoleToUser("houssem", "USER");
    }*/


}