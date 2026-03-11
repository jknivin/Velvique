package com.pillow.pillow.auth.dto;

import lombok.Data;

@Data
public class UserSignUpDTO {
    private String name;
    private String email;
    private String phone;
    private String password;
}
