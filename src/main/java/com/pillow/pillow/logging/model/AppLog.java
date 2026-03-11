package com.pillow.pillow.logging.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "app_logs")
@Getter
@Setter
public class AppLog {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, length = 30)
    private String level;

    @Column(nullable = false, length = 100)
    private String action;

    @Column(length = 255)
    private String email;

    @Column(nullable = false, length = 1000)
    private String message;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public AppLog() {
    }

    public AppLog(String level, String action, String email, String message) {
        this.level = level;
        this.action = action;
        this.email = email;
        this.message = message;
    }
}
