package com.pillow.pillow.common.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiResponse<T>{

    private final LocalDateTime time;
    private final int code;
    private final String message;
    private final T data;

    public ApiResponse(int code, String message , T data){
        this.time =LocalDateTime.now();
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
