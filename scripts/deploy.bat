@echo off
:: Variables
set APP_NAME=smart-city-traffic-monitoring-system
set DOCKER_IMAGE=cloudnativeplayground/%APP_NAME%:latest
set K8S_NAMESPACE=traffic-monitoring
set DEPLOYMENT_FILE=k8s-deployment.yaml

echo Starting deployment of %APP_NAME%...

:: Step 1: Build the Docker image
echo Building Docker image...
docker build -t %DOCKER_IMAGE% .

:: Step 2: Push the Docker image to Docker Hub (update if using another registry)
echo Pushing Docker image to Docker Hub...
docker push %DOCKER_IMAGE%

:: Step 3: Check for Kubernetes namespace and create if it doesn't exist
echo Checking for Kubernetes namespace...
kubectl get namespace %K8S_NAMESPACE% >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo Namespace %K8S_NAMESPACE% does not exist. Creating...
    kubectl create namespace %K8S_NAMESPACE%
) else (
    echo Namespace %K8S_NAMESPACE% already exists.
)

:: Step 4: Apply Kubernetes manifests
echo Applying Kubernetes deployment...
kubectl apply -f %DEPLOYMENT_FILE% -n %K8S_NAMESPACE%

:: Step 5: Check deployment status
echo Checking deployment status...
kubectl rollout status deployment/%APP_NAME% -n %K8S_NAMESPACE%

if %ERRORLEVEL% EQU 0 (
    echo Deployment of %APP_NAME% completed successfully!
) else (
    echo Deployment failed. Please check the logs for details.
    exit /b 1
)

pause
