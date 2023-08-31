package com.deca.securitysquad16.service;

import com.deca.securitysquad16.DTOs.UsersDTO;
import com.deca.securitysquad16.models.Users;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails loadUserByUsername(String username);

    Users addUser(UsersDTO userInfo);

    Users findByUser(Long id);
}
