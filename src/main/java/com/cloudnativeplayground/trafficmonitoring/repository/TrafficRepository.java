package com.cloudnativeplayground.trafficmonitoring.repository;

import com.cloudnativeplayground.trafficmonitoring.model.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing traffic data.
 * Extends JpaRepository to provide CRUD operations and more.
 */
@Repository
public interface TrafficRepository extends JpaRepository<TrafficData, Long> {

    /**
     * Custom method to find traffic data by location.
     *
     * @param location the location of the traffic data
     * @return a list of TrafficData for the specified location
     */
    List<TrafficData> findByLocation(String location);

    /**
     * Custom method to find traffic data by severity.
     *
     * @param severity the severity level of the traffic data
     * @return a list of TrafficData for the specified severity
     */
    List<TrafficData> findBySeverity(String severity);
}