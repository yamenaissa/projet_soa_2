package com.nadhem.user.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadhem.user.entities.User;
import com.nadhem.user.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserRESTController {

    @Autowired
    UserService userService;

    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

}
