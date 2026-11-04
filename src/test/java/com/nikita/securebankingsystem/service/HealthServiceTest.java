package com.nikita.securebankingsystem.service;

import com.nikita.securebankingsystem.dto.HealthResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HealthServiceTest {
    private final HealthService healthService = new HealthService();

    @Test
    void shouldReturnApplicationStatus(){
        HealthResponse response = healthService.getHealthStatus();
        assertNotNull(response);
        assertEquals("secure-banking-system", response.getApplication());
        assertEquals("UP",response.getStatus());
        assertNotNull(response.getTimestamp());
        
    }

}
