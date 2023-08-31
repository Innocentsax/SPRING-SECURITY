package com.deca.securitysquad16.serviceImpl;

import com.deca.securitysquad16.DTOs.UsersDTO;
import com.deca.securitysquad16.enums.Role;
import com.deca.securitysquad16.models.Users;
import com.deca.securitysquad16.repository.UserRepository;
import com.deca.securitysquad16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         return userRepository.findByUsername(username);
    }

    @Override
    public Users addUser(UsersDTO user) {
        return userRepository.save(new Users(user));
    }

//    @Override
//    public Users findByAdmin(Long id) {
//        return userRepository.findByRoleId(Role.ROLE_ADMIN, id).orElseThrow(()->new NullPointerException(String.format("No such ADMIN with ID: %d",id)));
//    }

    @Override
    public Users findByUser(Long id) {
        return userRepository.findByRoleAndId(Role.ROLE_USER, id).orElseThrow(()->new NullPointerException(String.format("No such USER with ID: %d",id)));
    }
}
