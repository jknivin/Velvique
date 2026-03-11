package com.pillow.pillow.auth.controller;

import com.pillow.pillow.auth.dto.AuthResponseDTO;
import com.pillow.pillow.auth.dto.UserSignInDTO;
import com.pillow.pillow.auth.dto.UserSignUpDTO;
import com.pillow.pillow.common.dto.ApiResponse;
import com.pillow.pillow.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> signUp(@Valid @RequestBody UserSignUpDTO data){
        return ResponseEntity.status(201)
                .body(new ApiResponse<>(201,"User Created successfully",authService.signUp(data)));
    }

    @PostMapping("/signin")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> signIn(@Valid @RequestBody UserSignInDTO data){
        return ResponseEntity.ok(new ApiResponse<>(200,"Login success",authService.login(data)));
    }

}
