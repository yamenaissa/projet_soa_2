package com.nadhem.user.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nadhem.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}