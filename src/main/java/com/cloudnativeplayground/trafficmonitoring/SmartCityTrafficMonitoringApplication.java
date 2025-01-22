package com.cloudnativeplayground.trafficmonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Smart City Traffic Monitoring System application.
 * This application provides real-time traffic updates, alerts, and visualizations.
 * It leverages Spring Boot, MQTT, and Kubernetes for its architecture.
 *
 * Maintainer: Aditya Pratap Bhuyan
 * License: GNU GPL v3
 */
@SpringBootApplication
public class SmartCityTrafficMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartCityTrafficMonitoringApplication.class, args);
        System.out.println("Smart City Traffic Monitoring System is up and running!");
    }
}
