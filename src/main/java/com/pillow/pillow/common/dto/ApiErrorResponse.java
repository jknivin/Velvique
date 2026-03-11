package com.pillow.pillow.common.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiErrorResponse {

    private final LocalDateTime time;
    private final int code;
    private final String message;

    public ApiErrorResponse(int code , String message){
        this.time = LocalDateTime.now();
        this.code = code;
        this.message = message;
    }

}
