package com.deca.securitysquad16.controllers;

import com.deca.securitysquad16.DTOs.UsersDTO;
import com.deca.securitysquad16.apis.AuthRequest;
import com.deca.securitysquad16.models.Users;
import com.deca.securitysquad16.repository.UserRepository;
import com.deca.securitysquad16.serviceImpl.UserServiceImpl;
import com.deca.securitysquad16.utils.JwtUtils;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
//ERROR CAUSED BY NO @RequestMapping????
@RequestMapping("/auth")
public class HomeController {

    private  UserServiceImpl userService;
    private final UserRepository userRepository;
    private final JwtUtils jwtService;
    private final AuthenticationManager authenticationManager;

    public HomeController(UserServiceImpl userService, UserRepository userRepository, JwtUtils jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>("Welcome this endpoint is not secure", HttpStatusCode.valueOf(200));
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<Users> addNewUser(@RequestBody UsersDTO userDto) {
        return new ResponseEntity<>(userService.addUser(userDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/user/userProfile/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @SecurityRequirement(name="Bearer Authentication")
    public ResponseEntity<Users> userProfile(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findByUser(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/admin/adminProfile/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @SecurityRequirement(name="Bearer Authentication")
    public ResponseEntity<Users> adminProfile(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findByUser(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/generateToken")
    public ResponseEntity<String> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return new ResponseEntity<>(jwtService.generateToken(userService.loadUserByUsername(authRequest.getUsername())), HttpStatusCode.valueOf(200));
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
