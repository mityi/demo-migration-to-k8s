./gradlew clean build docker

kubectl delete -f ./charts-local
kubectl delete -f ./charts
kubectl apply -f ./charts