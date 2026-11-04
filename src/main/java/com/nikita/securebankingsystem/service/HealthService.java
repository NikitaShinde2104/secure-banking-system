package com.nikita.securebankingsystem.service;

import com.nikita.securebankingsystem.dto.HealthResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class HealthService {

    public HealthResponse getHealthStatus(){
        return new HealthResponse("secure-banking-system",
        "UP",
                LocalDateTime.now());
    }
}
