# Smart City Traffic Monitoring System

## Overview
The **Smart City Traffic Monitoring System** is an open-source Java application that leverages IoT technologies to monitor and analyze traffic patterns in real-time. Built using Spring Boot, MQTT, and Kubernetes, it provides real-time updates, alerts, and visualization to improve urban traffic management.

## Features
- **Real-time Traffic Updates**: Instant updates on traffic conditions using MQTT.
- **Traffic Alerts**: Notifications for congestion, accidents, and other traffic-related events.
- **Visualization**: Interactive dashboards to view traffic patterns and metrics.
- **Cloud-Native Architecture**: Designed for scalability and deployment on Kubernetes.

## Tech Stack
- **Backend**: Java, Spring Boot
- **Messaging Protocol**: MQTT
- **Visualization**: HTML, CSS, JavaScript (Frontend framework to be decided)
- **Containerization**: Docker
- **Orchestration**: Kubernetes

## Prerequisites
- **Java**: JDK 17+
- **Maven**: 3.6+
- **Docker**: Installed and configured
- **Kubernetes**: Access to a cluster (local or cloud-based)
- **MQTT Broker**: Installed or accessible (e.g., Eclipse Mosquitto)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/cloudnativeplayground/smart-city-traffic-monitoring-system.git
   cd smart-city-traffic-monitoring-system
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   java -jar target/smart-city-traffic-monitoring-system.jar
   ```

## Deployment
- **Docker**:
    1. Build the Docker image:
       ```bash
       docker build -t traffic-monitoring-system .
       ```
    2. Run the Docker container:
       ```bash
       docker run -p 8080:8080 traffic-monitoring-system
       ```

- **Kubernetes**:
    1. Apply the Kubernetes manifests:
       ```bash
       kubectl apply -f k8s/
       ```
    2. Access the service:
       Use the Kubernetes LoadBalancer or NodePort URL to access the application.

## Folder Structure
```
smart-city-traffic-monitoring-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cloudnativeplayground/
│   │   │           └── trafficmonitoring/
│   │   │               ├── SmartCityTrafficMonitoringApplication.java
│   │   │               ├── config/
│   │   │               ├── controller/
│   │   │               ├── service/
│   │   │               ├── model/
│   │   │               └── repository/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
├── src/
│   └── test/
├── scripts/
├── Dockerfile
├── pom.xml
└── .gitignore
```

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Submit a pull request.

## License
This project is licensed under the GNU General Public License v3.0. See the `LICENSE` file for details.

## Maintainer
- **Aditya Pratap Bhuyan**  
  Senior Architect, Developer, Instructor, and Author  
  [LinkedIn Profile](https://linkedin.com/in/adityabhuyan)

