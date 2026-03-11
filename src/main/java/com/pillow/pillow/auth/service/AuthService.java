package com.pillow.pillow.auth.service;

import com.pillow.pillow.auth.dto.AuthResponseDTO;
import com.pillow.pillow.auth.dto.UserSignInDTO;
import com.pillow.pillow.auth.dto.UserSignUpDTO;
import com.pillow.pillow.auth.exception.UserAlreadyExistsException;
import com.pillow.pillow.auth.exception.UserNotFound;
import com.pillow.pillow.auth.model.Enum.UserRole;
import com.pillow.pillow.auth.model.Enum.UserStatus;
import com.pillow.pillow.auth.model.UserModel;
import com.pillow.pillow.auth.repository.UserRepository;
import com.pillow.pillow.common.JwtUtil;
import com.pillow.pillow.logging.service.AppLogService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AppLogService appLogService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AppLogService appLogService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.appLogService = appLogService;
    }

    public AuthResponseDTO signUp(UserSignUpDTO data){

        if(userRepository.existsByEmail(data.getEmail())){
            appLogService.warn("AUTH_SIGNUP_FAILED", data.getEmail(), "Signup failed because email already exists");
            throw new UserAlreadyExistsException("User already exists by this email");
        }

        UserModel user = new UserModel();
        user.setEmail(data.getEmail());
        user.setName(data.getName());
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(UserRole.ROLE_USER);
        user.setPhone(data.getPhone());
        user.setPassword(passwordEncoder.encode(data.getPassword()));

        UserModel savedModel = userRepository.save(user);
        appLogService.info("AUTH_SIGNUP_SUCCESS", savedModel.getEmail(), "User signup successful");

        String token = jwtUtil.generateToken(savedModel.getEmail());

        return new AuthResponseDTO(
                savedModel.getId(),
                savedModel.getName(),
                savedModel.getEmail(),
                savedModel.getPhone(),
                token
        );
    }

    public AuthResponseDTO login(UserSignInDTO data){

        UserModel user = userRepository.findByEmail(data.getEmail())
                .orElseThrow(() -> {
                    appLogService.warn("AUTH_SIGNIN_FAILED", data.getEmail(), "Signin failed because user was not found");
                    return new UserNotFound("User not found with email " + data.getEmail());
                });

        if(!passwordEncoder.matches(data.getPassword(),user.getPassword())){
            appLogService.warn("AUTH_SIGNIN_FAILED", data.getEmail(), "Signin failed because password is incorrect");
            throw new BadCredentialsException("Incorrect password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        appLogService.info("AUTH_SIGNIN_SUCCESS", user.getEmail(), "User signin successful");
        return new AuthResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone(), token);

    }

}
