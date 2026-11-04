
package com.nikita.securebankingsystem.controller;

import com.nikita.securebankingsystem.dto.HealthResponse;
import com.nikita.securebankingsystem.service.HealthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HealthController.class)
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HealthService healthService;

    @Test
    void shouldReturnHealthStatus() throws Exception {

        // Arrange
        HealthResponse response = new HealthResponse(
                "secure-banking-system",
                "UP",
                LocalDateTime.now()
        );

        when(healthService.getHealthStatus()).thenReturn(response);

        // Act and Assert
        mockMvc.perform(get("/api/v1/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.application")
                        .value("secure-banking-system"))
                .andExpect(jsonPath("$.status")
                        .value("UP"))
                .andExpect(jsonPath("$.timestamp").exists());
    }
}
