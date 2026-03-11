package com.pillow.pillow.auth.dto;

import lombok.Data;

@Data
public class UserSignInDTO {
    private String email;
    private String password;
}
