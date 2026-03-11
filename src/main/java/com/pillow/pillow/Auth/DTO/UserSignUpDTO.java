package com.pillow.pillow.Auth.DTO;

import lombok.Data;

@Data
public class UserSignUpDTO {
    private String name;
    private String email;
    private String phone;
    private String password;
}
