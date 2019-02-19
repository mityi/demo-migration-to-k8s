#!/usr/bin/env bash

./gradlew clean build docker

kubectl delete -f ./charts
kubectl apply -f ./charts