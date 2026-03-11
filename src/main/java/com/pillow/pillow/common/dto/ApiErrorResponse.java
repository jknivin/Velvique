package com.pillow.pillow.common.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiErrorResponse {

    private LocalDateTime time;
    private int code;
    private String message;

    public ApiErrorResponse(int code , String message){
        this.time = LocalDateTime.now();
        this.code = code;
        this.message = message;
    }

}
