package com.pillow.pillow.Auth.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class AuthResponseDTO {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String token;

}
