package com.pillow.pillow.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiResponse<T>{

    private LocalDateTime time;
    private int code;
    private String message;
    private T data;

    public ApiResponse(int code, String message , T data){
        this.time =LocalDateTime.now();
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
