package com.pillow.pillow.common.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GlobalErrorDTO {

    private LocalDateTime time;
    private int code;
    private String message;

    public GlobalErrorDTO(int code , String message){
        this.time = LocalDateTime.now();
        this.code = code;
        this.message = message;
    }

}
