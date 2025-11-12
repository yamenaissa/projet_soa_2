package com.nadhem.user.service;

import java.util.List;

import com.nadhem.user.entities.Role;
import com.nadhem.user.entities.User;

public interface UserService {
    User saveUser(User user);

    User findUserByUsername(String username);

    Role addRole(Role role);

    User addRoleToUser(String username, String rolename);

    List<User> findAllUsers();
}
