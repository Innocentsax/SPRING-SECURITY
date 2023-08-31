package com.deca.securitysquad16.DTOs;

import com.deca.securitysquad16.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDTO {
    private String username;
    private String password;
    private String role;
}
