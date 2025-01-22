package com.cloudnativeplayground.trafficmonitoring.controller;

import com.cloudnativeplayground.trafficmonitoring.model.TrafficData;
import com.cloudnativeplayground.trafficmonitoring.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/traffic")
public class TrafficController {

    private final TrafficService trafficService;

    @Autowired
    public TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @GetMapping("/data")
    public ResponseEntity<List<TrafficData>> getAllTrafficData() {
        List<TrafficData> trafficData = trafficService.getAllTrafficData();
        return new ResponseEntity<>(trafficData, HttpStatus.OK);
    }

    @PostMapping("/data")
    public ResponseEntity<TrafficData> addTrafficData(@RequestBody TrafficData trafficData) {
        TrafficData savedData = trafficService.addTrafficData(trafficData);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<TrafficData> getTrafficDataById(@PathVariable Long id) {
        TrafficData trafficData = trafficService.getTrafficDataById(id);
        return new ResponseEntity<>(trafficData, HttpStatus.OK);
    }

    @DeleteMapping("/data/{id}")
    public ResponseEntity<Void> deleteTrafficData(@PathVariable Long id) {
        trafficService.deleteTrafficData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/data/{id}")
    public ResponseEntity<TrafficData> updateTrafficData(@PathVariable Long id, @RequestBody TrafficData trafficData) {
        TrafficData updatedData = trafficService.updateTrafficData(id, trafficData);
        return new ResponseEntity<>(updatedData, HttpStatus.OK);
    }
}