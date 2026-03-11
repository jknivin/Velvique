package com.pillow.pillow.logging.controller;

import com.pillow.pillow.common.DTO.GlobalResponseDTO;
import com.pillow.pillow.logging.model.AppLog;
import com.pillow.pillow.logging.service.AppLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
@PreAuthorize("hasRole('ADMIN')")
public class LogController {

    private final AppLogService appLogService;

    public LogController(AppLogService appLogService){
        this.appLogService = appLogService;
    }

    @GetMapping
    public ResponseEntity<GlobalResponseDTO<List<AppLog>>> getLogs(){
        return ResponseEntity.ok(new GlobalResponseDTO<>(200,"Logs fetched successfully",appLogService.getLogs()));
    }

}
