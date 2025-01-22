package com.cloudnativeplayground.trafficmonitoring.service;

import com.cloudnativeplayground.trafficmonitoring.model.TrafficData;
import com.cloudnativeplayground.trafficmonitoring.repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TrafficService {

    private final MqttClient mqttClient;

    @Autowired
    public TrafficService(MqttClient mqttClient, TrafficRepository trafficRepository) {
        this.mqttClient = mqttClient;
        this.trafficRepository = trafficRepository;
    }

    /**
     * Processes incoming traffic data and triggers alerts if necessary.
     *
     * @param trafficData Traffic data object containing traffic information.
     */
    public void processTrafficData(TrafficData trafficData) {
        // Logic to analyze traffic data
        System.out.println("Processing traffic data: " + trafficData);

        if (trafficData.getVehicleCount() > 80) {
            sendAlert("High congestion detected at " + trafficData.getLocation());
        }

        // Publish traffic data to MQTT topic
        publishToMqtt("traffic/updates", trafficData.toString());
    }

    /**
     * Sends an alert notification.
     *
     * @param alertMessage The message to send as an alert.
     */
    private void sendAlert(String alertMessage) {
        System.out.println("ALERT: " + alertMessage);

        // Example: Publish alert to an MQTT topic
        publishToMqtt("traffic/alerts", alertMessage);
    }

    /**
     * Publishes a message to the specified MQTT topic.
     *
     * @param topic   The MQTT topic to publish to.
     * @param message The message content.
     */
    private void publishToMqtt(String topic, String message) {
        try {
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            mqttMessage.setQos(1); // Set QoS level to 1
            mqttClient.publish(topic, mqttMessage);
            System.out.println("Published to MQTT topic: " + topic);
        } catch (Exception e) {
            System.err.println("Error publishing to MQTT: " + e.getMessage());
        }
    }

    private final TrafficRepository trafficRepository;



    public List<TrafficData> getAllTrafficData() {
        return trafficRepository.findAll();
    }

    public TrafficData addTrafficData(TrafficData trafficData) {
        return trafficRepository.save(trafficData);
    }

    public TrafficData getTrafficDataById(Long id) {
        Optional<TrafficData> trafficData = trafficRepository.findById(id);
        return trafficData.orElseThrow(() -> new RuntimeException("Traffic data not found with id: " + id));
    }

    public void deleteTrafficData(Long id) {
        if (!trafficRepository.existsById(id)) {
            throw new RuntimeException("Traffic data not found with id: " + id);
        }
        trafficRepository.deleteById(id);
    }

    public TrafficData updateTrafficData(Long id, TrafficData updatedData) {
        if (!trafficRepository.existsById(id)) {
            throw new RuntimeException("Traffic data not found with id: " + id);
        }
        updatedData.setId(id);
        return trafficRepository.save(updatedData);
    }
}
