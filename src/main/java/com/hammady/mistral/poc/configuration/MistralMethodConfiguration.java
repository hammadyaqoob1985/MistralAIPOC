package com.hammady.mistral.poc.configuration;

import com.hammady.mistral.poc.dto.HealthStatus;
import com.hammady.mistral.poc.dto.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.Map;
import java.util.function.Function;

@Configuration
public class MistralMethodConfiguration {

    private Map<Patient, HealthStatus> patientStatuses;

    public MistralMethodConfiguration() {
        this.patientStatuses = Map.of(
                new Patient("P001"), new HealthStatus("Healthy"),
                new Patient("P002"), new HealthStatus("Has cough"),
                new Patient("P003"), new HealthStatus("Healthy"),
                new Patient("P004"), new HealthStatus("Has increased blood pressure"),
                new Patient("P005"), new HealthStatus("Healthy"));
    }

    @Bean
    @Description("Get patient health status")
    public Function<Patient, String> retrievePatientHealthStatus() {
        return (patient) -> this.patientStatuses.get(patient).status();
    }
}
