package com.deca.securitysquad16.controllers;

import com.deca.securitysquad16.DTOs.UsersDTO;
import com.deca.securitysquad16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {
    private UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup/users")
    public ModelAndView signUp(){
        return new ModelAndView("signup").addObject("user", new UsersDTO());
    }

    @PostMapping("/signup/users")
    public String signUp(@ModelAttribute UsersDTO usersDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "home";
        }
        try {
            usersDTO.setRole("ROLE_USER");
            userService.addUser(usersDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "/hello";
    }
}
