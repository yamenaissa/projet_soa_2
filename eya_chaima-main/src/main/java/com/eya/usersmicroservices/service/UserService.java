package com.eya.usersmicroservices.service;

import com.eya.usersmicroservices.entities.Role;
import com.eya.usersmicroservices.entities.User;
import com.eya.usersmicroservices.service.register.RegistrationRequest;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    List<User> findAllUsers();
    User registerUser(RegistrationRequest request );
    public void sendEmailUser(User u, String code);
    public User validateToken(String code);
}