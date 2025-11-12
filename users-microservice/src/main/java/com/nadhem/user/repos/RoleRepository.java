package com.nadhem.user.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nadhem.user.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);

}