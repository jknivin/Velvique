package com.pillow.pillow.auth.dto;

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
