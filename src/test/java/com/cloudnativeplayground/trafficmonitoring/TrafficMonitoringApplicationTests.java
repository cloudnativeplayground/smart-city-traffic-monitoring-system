package com.cloudnativeplayground.trafficmonitoring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmartCityTrafficMonitoringApplicationTests {

    @Test
    void contextLoads() {
        // Test if the application context loads successfully
    }

    @Test
    void applicationStartsCorrectly() {
        // Test if the application starts without throwing exceptions
        SmartCityTrafficMonitoringApplication.main(new String[] {});
    }
}
