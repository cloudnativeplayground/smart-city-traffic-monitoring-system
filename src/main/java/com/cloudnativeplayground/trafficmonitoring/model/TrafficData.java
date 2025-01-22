package com.cloudnativeplayground.trafficmonitoring.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Represents the traffic data collected from IoT sensors.
 */
@Entity
public class TrafficData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int vehicleCount;

    @Column(nullable = false)
    private double averageSpeed;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String severity;

    public TrafficData() {
    }

    public TrafficData(String location, int vehicleCount, double averageSpeed,String severity, LocalDateTime timestamp) {
        this.location = location;
        this.vehicleCount = vehicleCount;
        this.averageSpeed = averageSpeed;
        this.severity = severity;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public void setVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TrafficData{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", vehicleCount=" + vehicleCount +
                ", averageSpeed=" + averageSpeed +
                ", timestamp=" + timestamp +
                '}';
    }
}
