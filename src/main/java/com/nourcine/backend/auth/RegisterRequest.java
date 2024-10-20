package com.nourcine.backend.auth;

import com.nourcine.backend.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String firstname;
    String lastname;
    String email;
    String password;
     private Role role;

}