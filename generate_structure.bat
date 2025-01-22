@echo off
:: Root folders
mkdir src
mkdir src\main
mkdir src\main\java
mkdir src\main\resources
mkdir src\main\resources\static
mkdir src\main\resources\templates
mkdir src\test
mkdir src\test\java
mkdir scripts

:: Java package folders
mkdir src\main\java\com
mkdir src\main\java\com\cloudnativeplayground
mkdir src\main\java\com\cloudnativeplayground\trafficmonitoring
mkdir src\main\java\com\cloudnativeplayground\trafficmonitoring\config
mkdir src\main\java\com\cloudnativeplayground\trafficmonitoring\controller
mkdir src\main\java\com\cloudnativeplayground\trafficmonitoring\service
mkdir src\main\java\com\cloudnativeplayground\trafficmonitoring\model
mkdir src\main\java\com\cloudnativeplayground\trafficmonitoring\repository
mkdir src\test\java\com
mkdir src\test\java\com\cloudnativeplayground
mkdir src\test\java\com\cloudnativeplayground\trafficmonitoring

:: Application files
echo package com.cloudnativeplayground.trafficmonitoring; > src\main\java\com\cloudnativeplayground\trafficmonitoring\SmartCityTrafficMonitoringApplication.java
echo package com.cloudnativeplayground.trafficmonitoring.config; > src\main\java\com\cloudnativeplayground\trafficmonitoring\config\MqttConfig.java
echo package com.cloudnativeplayground.trafficmonitoring.controller; > src\main\java\com\cloudnativeplayground\trafficmonitoring\controller\TrafficController.java
echo package com.cloudnativeplayground.trafficmonitoring.service; > src\main\java\com\cloudnativeplayground\trafficmonitoring\service\TrafficService.java
echo package com.cloudnativeplayground.trafficmonitoring.model; > src\main\java\com\cloudnativeplayground\trafficmonitoring\model\TrafficData.java
echo package com.cloudnativeplayground.trafficmonitoring.repository; > src\main\java\com\cloudnativeplayground\trafficmonitoring\repository\TrafficRepository.java
echo package com.cloudnativeplayground.trafficmonitoring; > src\test\java\com\cloudnativeplayground\trafficmonitoring\TrafficMonitoringApplicationTests.java

:: Other files
echo # Dockerfile > Dockerfile
echo # Maven pom.xml > pom.xml
echo echo Deployment script > scripts\deploy.sh

echo All files and folders created successfully!
pause
