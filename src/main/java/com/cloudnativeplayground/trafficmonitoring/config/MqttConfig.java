package com.cloudnativeplayground.trafficmonitoring.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    private static final String BROKER_URL = "tcp://localhost:1883"; // Replace with your MQTT broker URL
    private static final String CLIENT_ID = "TrafficMonitoringClient";

    @Bean
    public MqttClient mqttClient() {
        try {
            // Initialize MQTT client
            MqttClient mqttClient = new MqttClient(BROKER_URL, CLIENT_ID, new MemoryPersistence());

            // Configure connection options
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);
            connectOptions.setAutomaticReconnect(true);
            connectOptions.setConnectionTimeout(10);

            // Connect to the broker
            mqttClient.connect(connectOptions);
            System.out.println("Connected to MQTT Broker: " + BROKER_URL);

            return mqttClient;
        } catch (MqttException e) {
            throw new RuntimeException("Failed to connect to MQTT Broker: " + BROKER_URL, e);
        }
    }
}
