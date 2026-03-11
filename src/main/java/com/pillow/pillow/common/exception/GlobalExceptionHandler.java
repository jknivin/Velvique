package com.pillow.pillow.common.exception;

import com.pillow.pillow.auth.exception.UserAlreadyExistsException;
import com.pillow.pillow.auth.exception.UserNotFound;
import com.pillow.pillow.common.dto.GlobalErrorDTO;
import com.pillow.pillow.product.exception.ProductNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<GlobalErrorDTO> handleUserNotFound(UserNotFound ex){
        return ResponseEntity.status(404).body(new GlobalErrorDTO(404,ex.getMessage()));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<GlobalErrorDTO> handleUserAlreadyExists(UserAlreadyExistsException ex){
        return ResponseEntity.status(409).body(new GlobalErrorDTO(409,ex.getMessage()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<GlobalErrorDTO> handleBadCredentials(BadCredentialsException ex) {
        return ResponseEntity.status(401).body(new GlobalErrorDTO(401, ex.getMessage()));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<GlobalErrorDTO> handleProductNotFound(ProductNotFoundException ex){
        return  ResponseEntity.status(404).body(new GlobalErrorDTO(404,ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorDTO> handleGeneric(Exception ex){
        return ResponseEntity.status(500).body(new GlobalErrorDTO(500,ex.getMessage()));
    }

}
