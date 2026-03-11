package com.pillow.pillow.logging.repository;

import com.pillow.pillow.logging.model.AppLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public interface AppLogRepository extends JpaRepository<AppLog, UUID> {

    long deleteByCreatedAtBefore(LocalDateTime expiryTime);
}
