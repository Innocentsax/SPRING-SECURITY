package com.deca.securitysquad16.repository;

import com.deca.securitysquad16.enums.Role;
import com.deca.securitysquad16.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    Optional<Users> findByRoleAndId(Role roleUser, Long id);
}
