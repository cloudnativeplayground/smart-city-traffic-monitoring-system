#!/bin/bash

# Exit immediately if a command exits with a non-zero status
set -e

# Variables
APP_NAME="smart-city-traffic-monitoring-system"
DOCKER_IMAGE="cloudnativeplayground/${APP_NAME}:latest"
K8S_NAMESPACE="traffic-monitoring"
DEPLOYMENT_FILE="k8s-deployment.yaml"

echo "Starting deployment of ${APP_NAME}..."

# Build the Docker image
echo "Building Docker image..."
docker build -t $DOCKER_IMAGE .

# Push the Docker image to Docker Hub (update to your registry if necessary)
echo "Pushing Docker image to Docker Hub..."
docker push $DOCKER_IMAGE

# Create Kubernetes namespace if it doesn't exist
echo "Checking for Kubernetes namespace..."
kubectl get namespace $K8S_NAMESPACE || kubectl create namespace $K8S_NAMESPACE

# Apply Kubernetes manifests
echo "Applying Kubernetes deployment..."
kubectl apply -f $DEPLOYMENT_FILE -n $K8S_NAMESPACE

# Check deployment status
echo "Checking deployment status..."
kubectl rollout status deployment/${APP_NAME} -n $K8S_NAMESPACE

echo "Deployment of ${APP_NAME} completed successfully!"
