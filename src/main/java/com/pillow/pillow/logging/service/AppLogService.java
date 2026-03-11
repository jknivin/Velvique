package com.pillow.pillow.logging.service;

import com.pillow.pillow.logging.model.AppLog;
import com.pillow.pillow.logging.repository.AppLogRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppLogService {

    private final AppLogRepository appLogRepository;

    public AppLogService(AppLogRepository appLogRepository) {
        this.appLogRepository = appLogRepository;
    }

    public void info(String action, String email, String message) {
        appLogRepository.save(new AppLog("INFO", action, email, message));
    }

    public void warn(String action, String email, String message) {
        appLogRepository.save(new AppLog("WARN", action, email, message));
    }

    public void error(String action, String email, String message) {
        appLogRepository.save(new AppLog("ERROR", action, email, message));
    }

    public List<AppLog> getLogs(){
        return appLogRepository.findAll();
    }

    // Runs hourly and removes logs older than 24 hours.
    @Scheduled(cron = "0 0 * * * *")
    public void deleteExpiredLogs() {
        LocalDateTime expiryTime = LocalDateTime.now().minusHours(24);
        long deletedLogs = appLogRepository.deleteByCreatedAtBefore(expiryTime);
        System.out.println("Deleted "+deletedLogs + " expired logs");
    }
}
