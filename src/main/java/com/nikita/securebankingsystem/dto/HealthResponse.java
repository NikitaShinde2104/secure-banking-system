package com.nikita.securebankingsystem.dto;

import java.time.LocalDateTime;

public class HealthResponse {
    private  String application;
    private  String status;
    private LocalDateTime timestamp ;

    public HealthResponse(String application, String status, LocalDateTime timestamp) {
        this.application = application;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getApplication() {
        return application;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
